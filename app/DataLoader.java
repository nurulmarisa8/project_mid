package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import service.UserManager;
import model.Dosen;
import model.Mahasiswa;
import model.MataKuliah;

public class DataLoader {

    public static void loadMahasiswaFromFile(String filePath, UserManager userManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length >= 1) {
                    String[] mhsData = parts[0].split(",");

                    if (mhsData.length >= 6) {
                        String nim = mhsData[0].trim();
                        String password = mhsData[1].trim();
                        String nama = mhsData[2].trim();
                        String jurusan = mhsData[3].trim();
                        String semester = mhsData[4].trim();
                        int sks = 0;

                        try {
                            sks = Integer.parseInt(mhsData[5].trim());
                        } catch (NumberFormatException e) {
                            sks = 2;  
                        }

                        Mahasiswa mhs = new Mahasiswa(nim, password, nama, jurusan, semester, sks);

                        if (parts.length > 1) {
                            String[] courses = parts[1].split(",");
                            for (String course : courses) {
                                MataKuliah mk = new MataKuliah(course.trim(), course.trim(), 2); 
                                mhs.addCourse(mk);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error membaca file mahasiswa.txt: " + e.getMessage());
        }
    }

    public static void loadDosenFromFile(String filePath, UserManager userManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String nama = parts[2].trim();
                    String jurusan = parts.length > 3 ? parts[3].trim() : "";
                    Dosen dosen = new Dosen(username, password, nama, jurusan);

                    
                    for (int i = 4; i < parts.length; i++) {
                        String mkName = parts[i].trim();
                        if (!mkName.isEmpty()) {
                            
                            MataKuliah mk = new MataKuliah("MK" + i, mkName, 2);
                            dosen.getMataKuliahList().add(mk);
                        }
                    }

                    dosen.setUserManager(userManager);
                    userManager.addDosen(dosen);
                }
            }
        } catch (IOException e) {
            System.out.println("Error membaca file dosen.txt: " + e.getMessage());
        }
    }
}
