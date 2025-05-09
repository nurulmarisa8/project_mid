package models;
import java.util.Scanner;

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("SKS: " + sks);
    }

    public static MataKuliah inputMataKuliah() {
        Scanner scanner = new Scanner(System.in);

        String kode;
        while (true) {
            System.out.print("Masukkan kode mata kuliah: ");
            kode = scanner.nextLine();
            if (!kode.isEmpty()) {
                break; 
            }
            System.out.println("Kode mata kuliah tidak boleh kosong!");
        }

        String nama;
        while (true) {
            System.out.print("Masukkan nama mata kuliah: ");
            nama = scanner.nextLine();
            if (!nama.isEmpty()) {
                break; 
            }
            System.out.println("Nama mata kuliah tidak boleh kosong!");
        }

        int sks;
        while (true) {
            System.out.print("Masukkan jumlah SKS: ");
            if (scanner.hasNextInt()) {
                sks = scanner.nextInt();
                if (sks > 0) {
                    break; 
                } else {
                    System.out.println("Jumlah SKS harus lebih dari 0!");
                }
            } else {
                System.out.println("Input tidak valid! Harus berupa angka.");
                scanner.next(); 
            }
        }
        
        return new MataKuliah(kode, nama, sks);
    }

}
