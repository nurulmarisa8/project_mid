package models;

import java.util.List;

public class Mahasiswa extends User {
    private String studentId;
    private String major;
    private String faculty;
    private List<MataKuliah> mataKuliahDiambil;


    public Mahasiswa(String name, String studentId, String major, String faculty, String username, String password) {
        super(name, username, password, Role.MAHASISWA); 
        this.studentId = studentId;
        this.major = major;
        this.faculty = faculty;
    }


    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }


    public void displayProfile() {
        System.out.println("=== PROFIL MAHASISWA ===");
        System.out.println("Nama           : " + name);
        System.out.println("NIM            : " + studentId);
        System.out.println("Prodi          : " + major);
        System.out.println("Fakultas       : " + faculty);
    }
}
