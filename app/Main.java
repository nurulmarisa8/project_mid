package app;

import service.UserManager;
import service.KRSManager;

public class Main {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        KRSManager krsManager = new KRSManager(userManager);

        DataLoader.loadMahasiswaFromFile("data/mahasiswa.txt", userManager);
        DataLoader.loadDosenFromFile("data/dosen.txt", userManager);

        AppMenu appMenu = new AppMenu(userManager, krsManager);
        appMenu.start();
    }
}
