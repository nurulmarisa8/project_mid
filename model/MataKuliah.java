package model;

import java.util.ArrayList;
import java.util.List;

public class MataKuliah {
    private final String code;
    private final String name;
    private final int credits;

    
    public MataKuliah(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    
    public String getCourseInfo() {
        return code + " - " + name + " (" + credits + " SKS)";
    }

    
    public int getCredits() {
        return credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MataKuliah that = (MataKuliah) obj;
        return this.code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    public static List<MataKuliah> getAllMataKuliah() {
        List<MataKuliah> mataKuliahList = new ArrayList<>();
        return mataKuliahList;
    }
}
