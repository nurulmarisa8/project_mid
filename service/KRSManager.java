package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Mahasiswa;
import model.MataKuliah;

public class KRSManager {
    private Map<Mahasiswa, List<MataKuliah>> coursePlanMap = new HashMap<>();
    private List<MataKuliah> allCourses;

    public KRSManager(UserManager userManager) {
        allCourses = new ArrayList<>();
        allCourses.add(new MataKuliah("SI101", "Algoritma & Pemerograman", 10));
        allCourses.add(new MataKuliah("SI102", "Matematika Dasar I", 10));
        allCourses.add(new MataKuliah("SI103", "Fisika Dasar", 2));
        allCourses.add(new MataKuliah("SI104", "Biologi Dasar", 2));
        allCourses.add(new MataKuliah("SI105", "Pendidikan Pancasila", 2));
        allCourses.add(new MataKuliah("SI106", "Pendidikan Kewarganegaraan", 2));
        allCourses.add(new MataKuliah("SI107", "Pendidikan Agama Islam", 2));
        allCourses.add(new MataKuliah("SI108", "Kimia Dasar", 2));
    }

    public List<MataKuliah> getAllCourses() {
        return allCourses;
    }

    public void addCourse(Mahasiswa student, MataKuliah course) {
        int totalSKS = student.getCourseList().stream().mapToInt(MataKuliah::getCredits).sum();
        if (totalSKS + course.getCredits() > 20) {
            System.out.println("Batas maksimum 20 SKS telah tercapai. Anda tidak bisa menambahkan mata kuliah ini.");
        } else {
            List<MataKuliah> list = coursePlanMap.getOrDefault(student, new ArrayList<>());
            boolean courseAlreadyTaken = list.stream().anyMatch(mk -> mk.getCourseInfo().equals(course.getCourseInfo()));
            if (courseAlreadyTaken) {
                System.out.println("Mata kuliah " + course.getCourseInfo() + " sudah diambil.");
            } else {
                list.add(course);
                coursePlanMap.put(student, list);
                student.addCourse(course);
                System.out.println("Mata kuliah " + course.getCourseInfo() + " berhasil ditambahkan.");
                saveKRSToFile(student);
            }
        }
    }

    public void removeCourse(Mahasiswa student, MataKuliah course) {
        List<MataKuliah> list = coursePlanMap.get(student);
        if (list != null && list.contains(course)) {
            list.remove(course);
            coursePlanMap.put(student, list);
            student.getCourseList().remove(course);
            System.out.println("Mata kuliah berhasil dihapus.");
            saveKRSToFile(student);
        } else {
            System.out.println("Mata kuliah tidak ditemukan di KRS mahasiswa.");
        }
    }

    private void saveKRSToFile(Mahasiswa student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/krs.txt", false))) {
            writer.write(student.getNim() + ": ");
            List<MataKuliah> courseList = student.getCourseList();
            for (int i = 0; i < courseList.size(); i++) {
                writer.write(courseList.get(i).getCourseInfo());
                if (i < courseList.size() - 1) {
                    writer.write(", ");
                }
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error menyimpan KRS: " + e.getMessage());
        }
    }

    public void loadKRSFromFile(String filePath, UserManager userManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String nim = parts[0].trim();
                    String[] courses = parts[1].split(",");
                    Mahasiswa mahasiswa = userManager.findStudentByNIM(nim);
                    if (mahasiswa != null) {
                        List<MataKuliah> mkList = new ArrayList<>();
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
                                MataKuliah mk = new MataKuliah(code, name, sks);
                                mkList.add(mk);
                            }
                        }
                        coursePlanMap.put(mahasiswa, mkList);
                        mahasiswa.getCourseList().clear();
                        mahasiswa.getCourseList().addAll(mkList);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Gagal membaca file KRS: " + e.getMessage());
        }
    }

    public void viewStudentKRS(Mahasiswa mahasiswa) {
        System.out.println("Kartu Rencana Studi (KRS) untuk Mahasiswa: " + mahasiswa.getName());
        System.out.println();
        List<MataKuliah> mataKuliahList = coursePlanMap.get(mahasiswa);
        if (mataKuliahList != null && !mataKuliahList.isEmpty()) {
            for (MataKuliah mk : mataKuliahList) {
                System.out.println("- " + mk.getCourseInfo());
            }
        } else {
            System.out.println("Mahasiswa ini belum mengambil mata kuliah.");
        }
    }
}
