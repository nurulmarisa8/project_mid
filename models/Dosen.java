package models;

public class Dosen extends User {

    public Dosen(String name, String username, String password) {
        super(name, username, password, Role.DOSEN);
    }
    
}
