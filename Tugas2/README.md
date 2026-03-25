# TUGAS CLASS DIAGRAM

### Deskripsi Kasus

Kasus di kehidupan sehari-hari yang saya ambil adalah sebuah isu dimana banyak jalan/trotoar yang ada di Indonesia sudah rusak, namun minim adanya perbaikan yang dilakukan. Melalui permasalahan ini saya membayangkan sebuah sistem terintegrasi yang dapat menjembatani antara petugas konstruksi dan warga setempat terkait pelaporan jalan berlubang serta perbaikan yang dilakukan.

### Class Diagram

Berdasarkan deskripsi tersebut, saya menggunakan `Mermaid.ai` untuk membantu membuatkan saya Class Diagram tentang sistem tersebut. Dan didapatkan hasilnya seperti berikut:

```mmd
classDiagram
    class Pengguna {
        -idPengguna: String
        -nama: String
        -email: String
        -nomorTelepon: String
        -alamat: String
        +login()
        +logout()
        +updateProfil()
    }

    class Warga {
        -tipeWarga: String
        +laporkanKerusakan()
        +lihatStatusPerbaikan()
        +memberikanRating()
    }

    class Teknisi {
        -nomorLisensi: String
        -keahlian: String[]
        +menerbitkanPekerjaan()
        +updateStatusPekerjaan()
        +menguploadFoto()
    }

    class Administrator {
        -levelAkses: String
        +mengelolaPengguna()
        +mengelolaPelaporan()
        +menghasilkanLaporan()
        +mengelolaBudget()
    }

    class Pelaporan {
        -idPelaporan: String
        -tanggalPelaporan: Date
        -deskripsiKerusakan: String
        -lokasiKerusakan: String
        -koordinatGPS: String
        -fotoKerusakan: String[]
        -statusPelaporan: String
        +buatPelaporan()
        +editPelaporan()
        +hapusPelaporan()
        +verifikasiPelaporan()
    }

    class TingkatKerusakan {
        -idTingkat: String
        -nama: String
        -deskripsi: String
        -skalaKerusakan: Integer
        +getTingkatKerusakan()
    }

    class Perbaikan {
        -idPerbaikan: String
        -tanggalMulai: Date
        -tanggalSelesai: Date
        -statusPerbaikan: String
        -biayaPerbaikan: Double
        -fotoSebelumSesudah: String[]
        -catatanTeknisi: String
        +memulaiPerbaikan()
        +updateProgress()
        +menyelesaikanPerbaikan()
        +allocateTechnician()
    }

    class Rating {
        -idRating: String
        -skorRating: Integer
        -komentar: String
        -tanggalRating: Date
        +memberikanRating()
    }

    class Notifikasi {
        -idNotifikasi: String
        -isiNotifikasi: String
        -tanggalNotifikasi: Date
        -statusBaca: Boolean
        +kirimNotifikasi()
        +tandaiTerbaca()
    }

    class Laporan {
        -idLaporan: String
        -tanggalLaporan: Date
        -jeniLaporan: String
        -dataPelaporan: Pelaporan[]
        -totalKerusakan: Integer
        -totalPerbaikan: Integer
        +generateLaoran()
        +exportKeExcel()
    }

    Pengguna <|-- Warga
    Pengguna <|-- Teknisi
    Pengguna <|-- Administrator
    
    Warga "1" --> "*" Pelaporan : membuat
    Pelaporan "1" --> "1" TingkatKerusakan : memiliki
    Pelaporan "1" --> "*" Perbaikan : menghasilkan
    Teknisi "*" --> "*" Perbaikan : menangani
    Perbaikan "1" --> "1" Rating : menerima
    Warga "1" --> "*" Rating : memberikan
    
    Pengguna "1" --> "*" Notifikasi : menerima
    Administrator "1" --> "*" Laporan : membuat
    Laporan "1" --> "*" Pelaporan : memuat
    Laporan "1" --> "*" Perbaikan : memuat
```

Visualisasi Class Diagram:

![](assets/ClassDiagram.png)

### Kode Program Java

### Screenshot Output

### Prinsip OOP yang Digunakan

### Keunikan

Keunikan program ini sendiri terletak pada realitas bahwa isu ini benar-benar isu yang masih belum ada cara mengatasinya entah itu dari pemerintah maupun dari pihak lain. Sudah terdapat banyak percobaan untuk membuat pelaporan jalan berlubang menjadi lebih cepat untuk ditanggapi, namun pada kenyataannya masih belum ada pergerakan perbaikan untuk jalan-jalan tersebut. Oleh karena itu program ini menjadi salah satu konsep solusi yang bisa digunakan di dunia nyata.

Selain itu, program ini juga sebisa mungkin menerapkan simulasi sesuai dengan alur kerja di dunia nyata dimana:

`Warga -> Pelaporan -> Administrator -> Verifikasi -> Teknisi -> Perbaikan -> Laporan -> Administrator -> Laporan -> Warga`

Sehingga terdapat workflow yang jelas, bukan hanya definisi statis.
