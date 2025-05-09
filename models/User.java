package models;

// Interface untuk perilaku dasar
interface UniversityEntity {
    void displayInfo();
}

// Kelas abstrak sebagai dasar (Abstract Class)
public abstract class User implements UniversityEntity {
    protected String id;
    protected String nama;

    public User(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter dan Setter (Encapsulation)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Metode abstrak
    abstract void performRole();
}