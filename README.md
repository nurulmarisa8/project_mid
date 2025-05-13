# Sistem Manajemen Universitas

## Deskripsi
Program ini adalah simulasi sistem manajemen universitas berbasis console untuk mahasiswa. Mahasiswa dapat login, melihat profil, melihat daftar mata kuliah, mengisi dan melihat KRS.

## Fitur
- Login Mahasiswa
- Melihat Profil Mahasiswa
- Melihat Daftar Mata Kuliah
- Mengisi KRS (menambahkan mata kuliah ke KRS)
- Melihat KRS yang telah diisi

## Penerapan Prinsip OOP
- **Abstraction**: Class `User` bersifat abstrak untuk menyederhanakan generalisasi pengguna.
- **Inheritance**: `Mahasiswa` mewarisi atribut dan method dari `User`.
- **Encapsulation**: Atribut-atribut dalam kelas menggunakan access modifier dan getter/setter.
- **Polymorphism**: Penggunaan interface `IManageKRS` dan implementasi metode secara fleksibel.

## Struktur Class
- `User` (abstract class)
- `Mahasiswa` (extends User)
- `MataKuliah`
- `IManageKRS` (interface)
- `KRSManager` (implements IManageKRS)
- `Main`

## Cara Menjalankan
1. Compile semua file `.java`
2. Jalankan `Main.java`
3. Ikuti instruksi pada terminal

## Pembagian Tugas
- Gyerend Nydle Linta Mangaluk: Class `User`
- Naa'ilah Mazaya: Class `MataKuliah`
- Davidzen: Class `IManageKRS`
- Julio Rema Palotongan: Class `Mahasiswa`
- Nurul Marisa Clara Waldi: Class `KRSManager`,`Main` dan dokumentasi
