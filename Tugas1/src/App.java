public class App {
    public static void main(String[] args) throws Exception {
        
        //instantiation
        Vehicle familyCar = new Vehicle("Avanza", 2022, 120);
        Vehicle bus = new Vehicle("Harapan Jaya", 2006, 200);
        Vehicle bicycle = new Vehicle("Polygon", 2013, 40);
        Vehicle futureCar = new Vehicle("Matrix", 2090, 500);

        TaxiDriver taxiDriver = new TaxiDriver();
        BusDriver busDriver = new BusDriver();

        taxiDriver.drive(familyCar);
        busDriver.drive(bus);

        bicycle.setSpeed(0);

        busDriver.drive(bicycle);
        taxiDriver.drive(futureCar);
    }
}

class Vehicle {
    //Constructor
    private String brand;
    private int year;
    private int maxSpeed;

    public Vehicle(String brand, int year, int maxSpeed) {
        this.brand = brand;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    //Setter Getter
    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public int getSpeed() {
        return maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

abstract class Driver {
    abstract void drive(Vehicle vehicle);
}

class TaxiDriver extends Driver {
    @Override  
    void drive(Vehicle vehicle) {
        if(vehicle.getSpeed() >= 180){
            System.out.println("The taxi driver is joining Tokyo Drift using " + vehicle.getBrand() + " " + vehicle.getYear() + " now");
        }
        else if(vehicle.getSpeed() <= 0){
            System.out.println("Mana jalan oi");
        }
        else{
            System.out.println("The taxi driver is driving " + vehicle.getBrand() + " " + vehicle.getYear() + " to mencari nafkah");
        }
    }
}

class BusDriver extends Driver {
    @Override
    void drive(Vehicle vehicle) {
        if(vehicle.getSpeed() >= 180){
            System.out.println("The bus driver is driving " + vehicle.getBrand() + " " + vehicle.getYear() + " with ugal ugalan now");
        }
        else if(vehicle.getSpeed() <= 0){
            System.out.println("Mogok keknya, smgd");
        }
        else{
            System.out.println("The bus driver is missing his bus, anyway he's driving " + vehicle.getBrand() + " " + vehicle.getYear() + " for now");
        }
    }
}
