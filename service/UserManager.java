package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.Dosen;
import model.Mahasiswa;
import model.User;

public class UserManager {
    private final Map<String, User> users = new HashMap<>(); 

    public UserManager() {
        loadMahasiswaFromFile("data/mahasiswa.txt"); 
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Mahasiswa findStudentByNIM(String nim) {
        for (User user : users.values()) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNim().equals(nim)) {
                    return mahasiswa;
                }
            }
        }
        return null;
    }

    private void loadMahasiswaFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("username")) continue;

                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String username = parts[0];
                    String password = parts[1];
                    String name = parts[2];
                    String nim = parts[3];
                    String major = parts[4];
                    int semester = Integer.parseInt(parts[5]);

                    Mahasiswa mhs = new Mahasiswa(username, password, name, nim, major, semester);
                    users.put(username, mhs);
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file mahasiswa.txt: " + e.getMessage());
        }
    }

    public void addMahasiswa(Mahasiswa mhs) {
        users.put(mhs.getUsername(), mhs);
    }

    public void addDosen(Dosen dosen) {
        users.put(dosen.getUsername(), dosen);
    }
}
