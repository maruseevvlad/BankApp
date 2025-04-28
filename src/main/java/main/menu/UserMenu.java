package main.menu;

import main.Session;
import main.User;
import java.util.Scanner;

public class UserMenu {
    public static void showMenu() {
        User currentUser = Session.getCurrentUser();
        String operation = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Здравствуйте, " + currentUser.getUserName() + "! \n" +
                    "Выберите операцию из списка: \n" +
                    "1. Открыть счёт \n" +
                    "2. Выбрать счёт \n" +
                    "3. Выйти из аккаунта \n");
            operation = scanner.nextLine();
            switch (operation) {
                case "1": OpenAccountMenu.showMenu();
                    break;
                case "2": SelectAccount.showMenu();
                    break;
                case "3":
                    Session.clearSession();
                    MainMenu.setIsUserLogin(false);
                    return;
                default: System.out.println(operation + " - не является допустимым значением");
            }
        } while (!operation.equals("3"));
    }
}
