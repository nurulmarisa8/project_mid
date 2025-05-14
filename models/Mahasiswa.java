package models;

public class Mahasiswa {
    private String name;
    private String studentId;
    private String major;
    private String faculty;
   

    public Mahasiswa(String name, String studentId, String major, String faculty, int i) {
        this.name = name;
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
