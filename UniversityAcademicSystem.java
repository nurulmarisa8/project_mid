
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Dosen;
import models.Mahasiswa;
import models.User;
import service.KRSManager;

public class UniversityAcademicSystem extends KRSManager {
    private List<User> listUser = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private void tambahMahasiswa(Mahasiswa mahasiswa) {
        if (listUser.contains(mahasiswa)) {
            System.out.println("Mahasiswa telah terdaftar");
            return;
        }
        listUser.add(mahasiswa);
    }

    private void tambahDosen(Dosen dosen) {
        if (listUser.contains(dosen)) {
            System.out.println("Dosen telah terdaftar");
            return;
        }
        listUser.add(dosen);
    }



    public static void main(String[] args) {
        UniversityAcademicSystem neosia = new UniversityAcademicSystem();

        Mahasiswa mhs1 = new Mahasiswa("Gyerend linta", "H071241099", "Information System", "Faculty Of Natural Sciences","gyerend", "gyerend123");
        Dosen dsn1 = new Dosen("Ribal", "ribal", "ribal123");

        neosia.tambahMahasiswa(mhs1);
        neosia.tambahDosen(dsn1);

        neosia.showLoginMenu();
    }

    public void showLoginMenu() {
        System.out.println("===================================");
        System.out.println("Selamat Datang");
        System.out.println("Masukkan Username dan Password Anda");
        System.out.println("===================================");
        
        String username;
        int userIndex = -1;
        boolean usernameFound = false;

        do {
            System.out.print("Masukkan username anda: ");
            username = sc.next();
            sc.nextLine();  // Clear the buffer after reading username

            // Cek apakah username ada dalam daftar pengguna
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).username.equals(username)) {
                    userIndex = i;
                    usernameFound = true;
                    break;  // Jika sudah ditemukan, keluar dari loop
                }
            }

            // Jika username tidak ditemukan
            if (!usernameFound) {
                System.out.println("Username salah. Coba lagi.");
            }

        } while (!usernameFound);  // Teruskan loop sampai username ditemukan


        if (userIndex != -1) {
            System.out.print("Masukkan password anda : ");
            String password = sc.nextLine();

            boolean passwordMatch = listUser.get(userIndex).getPassword().equals(password);

            while (!passwordMatch) {
                System.out.println("Password salah. Coba lagi");
                System.out.print("Masukkan password anda : ");
                password = sc.nextLine();                
            }

            if (listUser.get(userIndex).getRole().equals(User.Role.MAHASISWA)) {
                showMahasiswaMenu();
            } else {
                showDosenMenu();
            }
        }
    }

    public void showMahasiswaMenu() {
        do {
            System.out.println("================================");
            System.out.println("Berhasil login sebagai mahasiswa");
            System.out.println("Pilih menu");
            System.out.println("================================");
            System.out.println("1. Tambah KRS");
            System.out.println("2. Logout");
            System.out.println("================================");
            System.out.println(">");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    
                    break;
                case "2":
                    System.out.println("Anda telah logout");
                    showLoginMenu();
                    break;
                default:
                    System.out.println("Menu tidak valid");
                    menu = sc.nextLine();
            }


        } while (true);   
    }

     public void showDosenMenu() {
        do {
            System.out.println("================================");
            System.out.println("Berhasil login sebagai dosen");
            System.out.println("Pilih menu");
            System.out.println("================================");
            System.out.println("1. Daftar Mahasiswa");
            System.out.println("2. Cari KRS berdasarkan NIM");
            System.out.println("3. Logout");
            System.out.println("================================");
            System.out.println(">");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    System.out.println("Anda telah logout");
                    showLoginMenu();
                    break;
                default:
                    System.out.println("Menu tidak valid");
                    menu = sc.nextLine();
            }


        } while (true);   
    }
}