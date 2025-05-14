package service;

import models.Mahasiswa;
import models.MataKuliah;

// Implementasi interface IManageKRS
public class KRSManager implements IManageKRS {
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