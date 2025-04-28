package main.menu;

import main.Session;
import main.User;
import java.util.List;
import java.util.Scanner;

public class SelectAccount {
    public static void showMenu() {
        User currentUser = Session.getCurrentUser();
        String operation = "";
        do {
            if (currentUser.getUserBankAccounts().isEmpty()) {
                System.out.println("На данный момент у вас нет счётов");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("С каким счётом вы хотите продолжить работать: \n" +
            "Для выхода введите 'exit'");
            showUserAccounts();
            operation = scanner.nextLine();

            if ("exit".equalsIgnoreCase(operation)) {
                Session.clearAccountSession();
                break;
            }

            if (hasIndex(currentUser.getUserBankAccounts(), Integer.parseInt(operation) - 1)) {
                Session.setCurrentAccount(currentUser.getUserBankAccounts().get(Integer.parseInt(operation) - 1));
                AccountSettings.showMenu();
            } else {
                System.out.println(operation + " - не является допустимым значением");
            }
        } while (true);
    }

    public static void showUserAccounts() {
       var userAccounts = Session.getCurrentUser().getUserBankAccounts();
       var j = 1;
       for (var i = 0; i < userAccounts.size(); i++){
           System.out.println(j + ". " + userAccounts.get(i));
           j++;
       }
    }

    public static boolean hasIndex(List<?> list, int n) {
        return list != null && n >= 0 && n < list.size();
    }
}
