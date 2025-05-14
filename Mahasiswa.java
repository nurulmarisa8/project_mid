package model;

import java.util.List;

public class Mahasiswa extends User {
    private List<MataKuliah> courseList;

    public Mahasiswa(String username, String password, String nama) {
        super(username, password, nama);
        this.courseList = courseList;
    }

    public List<MataKuliah> getCourseList() {
        return courseList;
    }

    public void viewStudyPlan() {
        if (courseList.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            System.out.println("Daftar Mata Kuliah yang Diambil:");
            for (int i = 0; i < courseList.size(); i++) {
                MataKuliah mk = courseList.get(i);
                System.out.println((i + 1) + ". " + mk.getKode() + " - " + mk.getNama());
            }
        }
    }
}
