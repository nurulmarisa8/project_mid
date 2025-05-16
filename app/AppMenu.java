package app;

import model.User;
import service.UserManager;
import service.KRSManager;
import model.Dosen;
import model.Mahasiswa;
import model.MataKuliah;

import java.util.Scanner;

public class AppMenu {
    private UserManager userManager;
    private KRSManager krsManager;

    public AppMenu(UserManager userManager, KRSManager krsManager) {
        this.userManager = userManager;
        this.krsManager = krsManager;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            User currentUser = null;
            System.out.println("==============================");
            System.out.println("Selamat Datang Di SIKOLA 3 ");
            System.out.println("==============================");
            System.out.println("Silakan login untuk melanjutkan.");
            System.out.println("==============================");
            System.out.print("NIM/NIP: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            currentUser = userManager.getUser(username);

            if (currentUser != null && currentUser.getPassword().equals(password)) {
                System.out.println("===================");
                System.out.println("Login berhasil!\n");
                showMenu(currentUser, sc);
            } else {
                System.out.println("Login gagal! Periksa username atau password.");
            }
        }
    }

    private void showMenu(User currentUser, Scanner sc) {
        while (true) {
            System.out.println("===================");

            if (currentUser instanceof Dosen) {
                showDosenMenu((Dosen) currentUser, sc);
                return;
            } else if (currentUser instanceof Mahasiswa) {
                showMahasiswaMenu((Mahasiswa) currentUser, sc);
                return;
            }
        }
    }

    private void showDosenMenu(Dosen dosen, Scanner sc) {
        System.out.println("Menu Dosen:");
        System.out.println("1. Lihat KRS Mahasiswa");
        System.out.println("2. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("3. Lihat Mata Kuliah yang Diajarkan");
        System.out.println("4. Logout");
        System.out.print("Pilih: ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                viewStudentKRS(dosen, sc);
                break;
            case "2":
                searchStudentByNIM(dosen, sc);
                break;
            case "3":
                viewMataKuliahDosen(dosen);
                break;
            case "4":
                System.out.println("Logout berhasil!");
                return;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void showMahasiswaMenu(Mahasiswa mahasiswa, Scanner sc) {
        while (true) {
            System.out.println("===================");
            System.out.println("Menu Mahasiswa:");
            System.out.println("1. Lihat Profil");
            System.out.println("2. Lihat Daftar Mata Kuliah");
            System.out.println("3. Isi KRS (Tambah Mata Kuliah)");
            System.out.println("4. Lihat KRS yang Diambil");
            System.out.println("5. Hapus Mata Kuliah dari KRS");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    mahasiswa.viewProfile();
                    break;
                case "2":
                    System.out.println("Daftar Mata Kuliah yang Tersedia:");
                    System.out.println("=========================");
                    System.out.println("");
                    int idx = 1;
                    for (MataKuliah mk : krsManager.getAllCourses()) {
                        System.out.println(idx++ + ". " + mk.getCourseInfo());
                    }
                    break;
                case "3":
                    addCourseToKRS(mahasiswa, sc);
                    break;
                case "4":
                    mahasiswa.viewStudyPlan();
                    break;
                case "5":
                    removeCourseFromKRS(mahasiswa, sc);
                    break;
                case "6":
                    System.out.println("Logout berhasil!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void viewStudentKRS(Dosen dosen, Scanner sc) {
        while (true) {
            System.out.println("========================");
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = sc.nextLine();
            try {
                krsManager.loadKRSFromFile("data/krs.txt", userManager);

                Mahasiswa mahasiswa = dosen.findStudentByNIM(nim);
                if (mahasiswa != null) {
                    krsManager.viewStudentKRS(mahasiswa);
                    break; 
                } else {
                    System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
                    System.out.print("Coba lagi? (y/n): ");
                    String ulang = sc.nextLine();
                    if (!ulang.equalsIgnoreCase("y")) {
                        break; 
                    }
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat mencari mahasiswa: " + e.getMessage());
                break;
            }
        }
    }

    private void searchStudentByNIM(Dosen dosen, Scanner sc) {
        while (true) {
            System.out.println("========================");
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = sc.nextLine();
            Mahasiswa mahasiswa = dosen.findStudentByNIM(nim);
            if (mahasiswa != null) {
                System.out.println("Mahasiswa ditemukan: " + mahasiswa.getName());
                break; 
            } else {
                System.out.println("Mahasiswa tidak ditemukan.");
                System.out.print("Coba lagi? (y/n): ");
                String ulang = sc.nextLine();
                if (!ulang.equalsIgnoreCase("y")) {
                    break; 
                }
            }
        }
    }

    private void viewMataKuliahDosen(Dosen dosen) {
        System.out.println("Mata Kuliah yang Diajarkan oleh " + dosen.getNama() + ":");
        if (dosen.getMataKuliahList().isEmpty()) {
            System.out.println("- Tidak ada mata kuliah yang diajarkan.");
        } else {
            for (MataKuliah mk : dosen.getMataKuliahList()) {
                System.out.println("- " + mk.getCourseInfo());
            }
        }
    }

    private void addCourseToKRS(Mahasiswa mahasiswa, Scanner sc) {
        java.util.List<MataKuliah> daftarMK = krsManager.getAllCourses();

        System.out.println("Daftar Mata Kuliah yang Tersedia:");
        System.out.println("=============================================");
        System.out.println("");
        for (int i = 0; i < daftarMK.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMK.get(i).getCourseInfo());
        }
        System.out.println("=============================================");
        System.out.print("Pilih nomor mata kuliah untuk ditambahkan: ");
        String pilihStr = sc.nextLine();
        int pilih = 0;

        try {
            pilih = Integer.parseInt(pilihStr);
        } catch (NumberFormatException e) {
            System.out.println("Pilihan tidak valid. Harap masukkan angka.");
            return;
        }

        if (pilih >= 1 && pilih <= daftarMK.size()) {
            MataKuliah selectedMK = daftarMK.get(pilih - 1);
            if (mahasiswa.getCourseList().size() < 6) {
                krsManager.addCourse(mahasiswa, selectedMK); 
            } else {
                System.out.println("Batas maksimum 20 SKS telah tercapai.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private void removeCourseFromKRS(Mahasiswa mahasiswa, Scanner sc) {
        mahasiswa.viewStudyPlan();
        System.out.println("=============================================");
        System.out.println("");
        System.out.print("Pilih nomor mata kuliah untuk dihapus dari KRS: ");
        String deleteStr = sc.nextLine();
        int deleteIndex = 0;

        try {
            deleteIndex = Integer.parseInt(deleteStr) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        if (deleteIndex >= 0 && deleteIndex < mahasiswa.getCourseList().size()) {
            MataKuliah courseToDelete = mahasiswa.getCourseList().get(deleteIndex);
            krsManager.removeCourse(mahasiswa, courseToDelete);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        return;
    }
}
