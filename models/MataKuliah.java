package models;

// Kelas MataKuliah yang meng-extend User (untuk keperluan inheritance)
public class MataKuliah extends User {
    private int sks;
    private String dosen;

    public MataKuliah(String id, String nama, int sks, String dosen) {
        super(id, nama);
        this.sks = sks;
        this.dosen = dosen;
    }

    // Getter dan Setter (Encapsulation)
    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    @Override
    public void displayInfo() {
        System.out.println("Kode Mata Kuliah: " + getId());
        System.out.println("Nama Mata Kuliah: " + getNama());
        System.out.println("SKS: " + sks);
        System.out.println("Dosen: " + dosen);
    }

    @Override
    void performRole() {
        System.out.println("Mata kuliah " + getNama() + " sedang diajarkan oleh " + dosen);
    }
}