package models;

import java.util.ArrayList;
import java.util.List;

// Kelas Mahasiswa yang meng-extend User
public class Mahasiswa extends User {
    private String jurusan;
    private List<MataKuliah> daftarMataKuliah;

    public Mahasiswa(String id, String nama, String jurusan) {
        super(id, nama);
        this.jurusan = jurusan;
        this.daftarMataKuliah = new ArrayList<>();
    }

    // Getter dan Setter (Encapsulation)
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public List<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    // Behavior
    public void ambilMataKuliah(MataKuliah mataKuliah) {
        daftarMataKuliah.add(mataKuliah);
        System.out.println("Berhasil mengambil mata kuliah: " + mataKuliah.getNama());
    }

    public void hapusMataKuliah(MataKuliah mataKuliah) {
        daftarMataKuliah.remove(mataKuliah);
        System.out.println("Berhasil drop mata kuliah: " + mataKuliah.getNama());
    }

    @Override
    public void displayInfo() {
        System.out.println("NIM: " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Jurusan: " + jurusan);
        System.out.println("Mata Kuliah yang Diambil:");
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil");
        } else {
            for (MataKuliah mataKuliah : daftarMataKuliah) {
                System.out.println("- " + mataKuliah.getNama() + " (" + mataKuliah.getSks() + " SKS)");
            }
        }
    }

    @Override
    void performRole() {
        System.out.println("Mahasiswa " + getNama() + " sedang belajar di jurusan " + jurusan);
    }
}