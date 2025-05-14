package models;

import java.util.ArrayList;
import java.util.List;


public class Mahasiswa extends User {
    private String studentId;
    private String major;
    private String faculty;
    private List<MataKuliah> mataKuliahDiambil;

    // Konstruktor
    public Mahasiswa(String name, String studentId, String major, String faculty, String username, String password) {
        super(name, username, password, Role.MAHASISWA); 
        this.studentId = studentId;
        this.major = major;
        this.faculty = faculty;
        this.mataKuliahDiambil = new ArrayList<>();
    }

    // Getter dan Setter
    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getFaculty() {
        return faculty;
    }

    public List<MataKuliah> getMataKuliahDiambil() {
        return mataKuliahDiambil;
    }


    public void ambilMataKuliah(MataKuliah mataKuliah) {
        mataKuliahDiambil.add(mataKuliah);
        System.out.println("Berhasil mengambil mata kuliah: " + mataKuliah.getName());
    }

    public void hapusMataKuliah(MataKuliah mataKuliah) {
        mataKuliahDiambil.remove(mataKuliah);
        System.out.println("Berhasil drop mata kuliah: " + mataKuliah.getName());
    }


    public void displayProfile() {
        System.out.println("=== PROFIL MAHASISWA ===");
        System.out.println("Nama           : " + getName());
        System.out.println("NIM            : " + studentId);
        System.out.println("Prodi          : " + major);
        System.out.println("Fakultas       : " + faculty);
        System.out.println("Mata Kuliah yang Diambil:");
        if (mataKuliahDiambil.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mataKuliah : mataKuliahDiambil) {
                System.out.println("- " + mataKuliah.getName() + " (" + mataKuliah.getSks() + " SKS)");
            }
        }
    }


    @Override
    void performRole() {
        System.out.println("Mahasiswa " + getName() + " sedang belajar di jurusan " + major);
    }
}
