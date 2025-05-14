package models;
import java.util.Scanner;

public class MataKuliah {
    private String code;
    private String name;
    private int credits;

    public MataKuliah(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void GetCourseInfo() {
        System.out.println("Kode: " + code);
        System.out.println("Nama: " + name);
        System.out.println("SKS: " + credits);
    }
}