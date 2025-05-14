package models;
import java.util.Scanner;

public class MataKuliah {
    private String code;
    private String name;
    private int credits;

    public MataKuliah (String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void GetCourseInfo() {
        System.out.println("Kode: " + code);
        System.out.println("Nama: " + name);
        System.out.println("SKS: " + credits);
    }

    public static MataKuliah inputCourse() {
        Scanner scanner = new Scanner(System.in);

        String code;
        while (true) {
            System.out.print("Masukkan kode mata kuliah: ");
            code = scanner.nextLine();
            if (!code.isEmpty()) {
                break; 
            }
            System.out.println("Kode mata kuliah tidak boleh kosong!");
        }

        String name;
        while (true) {
            System.out.print("Masukkan nama mata kuliah: ");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                break; 
            }
            System.out.println("Nama mata kuliah tidak boleh kosong!");
        }

        int credits;
        while (true) {
            System.out.print("Masukkan jumlah SKS: ");
            if (scanner.hasNextInt()) {
                credits = scanner.nextInt();
                if (credits > 0) {
                    break; 
                } else {
                    System.out.println("Jumlah SKS harus lebih dari 0!");
                }
            } else {
                System.out.println("Input tidak valid! Harus berupa angka.");
                scanner.next(); 
            }
        }
        
        return new MataKuliah(code, name, credits);
        
    }
}