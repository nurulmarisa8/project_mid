package service;

import models.Mahasiswa;
import models.MataKuliah;
import java.util.ArrayList;
import java.util.List;

public class KRSManager implements IManageKRS {
    private List<MataKuliah> mataKuliahList;

    
    public KRSManager() {
        mataKuliahList = new ArrayList<>();
        mataKuliahList.add(new MataKuliah("SI101", "Algoritma Pemrograman", 3));
        mataKuliahList.add(new MataKuliah("SI102", "Matematika Dasar", 3));
        mataKuliahList.add(new MataKuliah("SI103", "Pemrograman Berorientasi Objek", 3));
    }


    public List<MataKuliah> getAllCourses() {
        return mataKuliahList;
    }


    public void addCourse(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }


    @Override
    public void tambahMataKuliah(Mahasiswa mahasiswa, MataKuliah mataKuliah) {
        mahasiswa.ambilMataKuliah(mataKuliah); 
    }

    @Override
    public void hapusMataKuliah(Mahasiswa mahasiswa, MataKuliah mataKuliah) {
        mahasiswa.hapusMataKuliah(mataKuliah); 
    }

    @Override
    public void tampilkanKRS(Mahasiswa mahasiswa) {
        mahasiswa.displayInfo(); 
    }
}
