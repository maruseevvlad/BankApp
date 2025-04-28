package main;
import main.menu.MainMenu;

public class Main {
    static TimeNow timeNow;
    public static void main(String[] args) {
        timeNow = new TimeNow();
        Thread threadTime = new Thread(timeNow);
        threadTime.setDaemon(true);
        threadTime.start();

        MainMenu.showMenu();
    }
}