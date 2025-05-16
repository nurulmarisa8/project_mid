package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends User {
    private final String name;
    public String getName() {
        return name;
    }

    private final String nim;
    private final String major;
    private final int semester;

    public String getMajor() {
        return major;
    }

    public int getSemester() {
        return semester;
    }

    private final List<MataKuliah> courseList = new ArrayList<>();

    public Mahasiswa(String username, String password, String name, String nim, String major, int semester) {
        super(username, password);
        this.name = name;
        this.nim = nim;
        this.major = major;
        this.semester = semester;
    }

    public String getNim() {
        return nim;
    }

    public List<MataKuliah> getCourseList() {
        return courseList;
    }

    public void addCourse(MataKuliah mk) {
        courseList.add(mk);
    }

    public void viewProfile() {
        System.out.println("=========================");
        System.out.println("\nProfil Mahasiswa:");
        System.out.println("Nama: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + major);
        System.out.println("Semester: " + semester);
        System.out.println("=========================");
    }

    public void viewStudyPlan() {

        try (BufferedReader br = new BufferedReader(new FileReader("data/krs.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].trim().equals(this.nim)) {
                    courseList.clear();
                    String[] courses = parts[1].split(",");
                    for (String courseStr : courses) {
                        String[] info = courseStr.trim().split(" - | \\(| SKS\\)");
                        if (info.length >= 3) {
                            String code = info[0].trim();
                            String name = info[1].trim();
                            int sks = 2;
                            try {
                                sks = Integer.parseInt(info[2].trim());
                            } catch (NumberFormatException e) {
                                // default SKS
                            }
                            courseList.add(new MataKuliah(code, name, sks));
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Gagal membaca KRS: " + e.getMessage());
        }

        System.out.println("\nMata Kuliah yang Diambil:");
        if (courseList.isEmpty()) {
            System.out.println("- Tidak ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mk : courseList) {
                System.out.println("- " + mk.getCourseInfo());
            }
        }
    }

    public void logout() {
        System.out.println("Anda telah logout. Silakan login ulang.");
    }

    public void KRSManager() {
        throw new UnsupportedOperationException("Unimplemented method 'KRSManager'");
    }

    public void getAllMataKuliah() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllMataKuliah'");
    }

    public void getAllCourses() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllCourses'");
    }
}
