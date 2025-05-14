import java.util.ArrayList;
import java.util.List;
import models.MataKuliah; 

public class KRSManager implements IManageKRS {
    private List<MataKuliah> mataKuliahList;

    public KRSManager() {
        mataKuliahList = new ArrayList<>();
        mataKuliahList.add(new MataKuliah("SI101", "Algoritma Pemrograman", 3));
        mataKuliahList.add(new MataKuliah("SI102", "Matematika Dasar", 3));
        mataKuliahList.add(new MataKuliah("SI103", "Pemrograman Berorientasi Objek", 3));
    }

    @Override
    public List<MataKuliah> getAllCourses() {
        return mataKuliahList;
    }

    public void addCourse(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }
}
