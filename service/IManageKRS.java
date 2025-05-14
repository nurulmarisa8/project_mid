package service;

import models.Mahasiswa;
import models.MataKuliah;

// Interface untuk manajemen KRS (Polymorphism)
public interface IManageKRS {
    void tambahMataKuliah(Mahasiswa mahasiswa, MataKuliah mataKuliah);
    void hapusMataKuliah(Mahasiswa mahasiswa, MataKuliah mataKuliah);
    void tampilkanKRS(Mahasiswa mahasiswa);
}