package model;

import java.util.ArrayList;
import java.util.List;
import service.KRSManager;
import service.UserManager;

public class Dosen extends User {

    private UserManager userManager;
    private String name; 
    private String department; 
    private List<MataKuliah> mataKuliahList;

    
    public Dosen(String username, String password, String name, String department) {
        super(username, password);
        this.name = name;
        this.department = department;
        this.mataKuliahList = new ArrayList<>(); 
    }

    public Dosen(String username, String password, UserManager userManager2) {
        super(username, password);
        this.userManager = userManager2;
        this.mataKuliahList = new ArrayList<>();
    }

    public Dosen(String username, String password) {
        super(username, password);
    }


    public UserManager getUserManager() {
        return userManager;
    }

    
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    
    public String getName() {
        return name;
    }

    
    public String getDepartment() {
        return department;
    }

    
    public Mahasiswa findStudentByNIM(String nim) {
        return userManager.findStudentByNIM(nim);  
    }

    
    public void viewStudentKRS(Mahasiswa mahasiswa) {
        new KRSManager(userManager).viewStudentKRS(mahasiswa);  
    }

    
    public List<MataKuliah> getMataKuliahList() {
        return mataKuliahList;
    }
}
