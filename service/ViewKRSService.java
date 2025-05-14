
package service;


import java.util.List;
import models.Mahasiswa;
import models.MataKuliah;

public class ViewKRSService {

    public void studentViewKRS(Mahasiswa student) {
        List<MataKuliah> krs = student.getKrs();

        System.out.println("=== KRS for Student: " + student.getNama() + " ===");
        if (krs.isEmpty()) {
            System.out.println("No courses have been registered yet.");
        } else {
            for (MataKuliah course : krs) {
                System.out.println("- " + course.getKode() + " | " + course.getNama() + " | " + course.getSks() + " credits");
            }
        }
        System.out.println();
    }

    public void lecturerViewKRS(List<Mahasiswa> studentList, String nim) {
        Mahasiswa targetStudent = null;

        for (Mahasiswa student : studentList) {
            if (student.getNim().equalsIgnoreCase(nim)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent != null) {
            studentViewKRS(targetStudent); 
        } else {
            System.out.println("Student with NIM " + nim + " was not found.");
        }
    }
}
