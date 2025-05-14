package models;



public abstract class  User {
    public enum Role {
        DOSEN,
        MAHASISWA
    }

    public String username, name;
    protected  Role role;
    private String password;

    public User(String name, String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}