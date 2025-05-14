package service;

<<<<<<< HEAD
public class KRSManager{
    
=======
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
>>>>>>> 2ea82fa9f8edb3431c7e80f1b75ee6e26aa7b45e
}