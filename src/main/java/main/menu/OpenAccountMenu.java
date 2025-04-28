package main.menu;

import main.Session;
import main.User;
import java.util.Scanner;

public class OpenAccountMenu {
    public static void showMenu() {
        User currentUser = Session.getCurrentUser();
        String operation = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Какой счёт вы хотите открыть? \n" +
                    "1. Лицевой счёт \n" +
                    "2. Накопительный счёт \n" +
                    "3. Назад \n");
            operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    currentUser.addCheckingAccount();
                    break;
                case "2":
                    System.out.println("Какую сумму вы хотите положить на накопительный счёт? \n");
                    currentUser.addSavingAccount(Double.parseDouble(scanner.nextLine()));
                    break;
                case "3":
                    return;
                default:
                    System.out.println(operation + " - не является допустимым значением");
            }
        } while (operation != "3");
    }
}
