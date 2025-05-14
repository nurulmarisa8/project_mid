package models;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Mahasiswa[] ListMahasiswa = {
            new Mahasiswa("Julio Rema Palotongan", "H071241017", "Information Systems", "Faculty of Science and Mathematics", 2024),
            new Mahasiswa("Revaldy Amahn", "D03122156", "Naval Engineering", "Faculty of Engineering", 2022),
            new Mahasiswa("Budi Santoso", "F031230157", "Arabic Literature", "Faculty of Cultural Sciences", 2023)
        };

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String nameInput = input.nextLine();
        System.out.print("Enter Student ID: ");
        String idInput = input.nextLine();

        boolean found = false;
        for (Mahasiswa student : ListMahasiswa) {
            if (student.getName().equalsIgnoreCase(nameInput) && student.getStudentId().equals(idInput)) {
                student.displayProfile();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student data not found.");
        }

        input.close();
    }
}
