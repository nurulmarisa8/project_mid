package models;

import java.util.Scanner;


public class MataKuliah extends User {
    private String code;  
    private String name;  
    private int credits;  
    private String dosen; 


    public MataKuliah(String id, String name, int credits, String dosen) {
        super(id, name); 
        this.code = id;
        this.name = name;
        this.credits = credits;
        this.dosen = dosen;
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

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }


    public void displayInfo() {
        System.out.println("Kode Mata Kuliah: " + getCode());
        System.out.println("Nama Mata Kuliah: " + getName());
        System.out.println("SKS: " + credits);
        System.out.println("Dosen: " + dosen);
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

        String dosen;
        while (true) {
            System.out.print("Masukkan nama dosen: ");
            dosen = scanner.nextLine();
            if (!dosen.isEmpty()) {
                break;
            }
            System.out.println("Nama dosen tidak boleh kosong!");
        }

        return new MataKuliah(code, name, credits, dosen);
    }

    @Override
    void performRole() {
        System.out.println("Mata kuliah " + getName() + " sedang diajarkan oleh " + dosen);
    }
}
