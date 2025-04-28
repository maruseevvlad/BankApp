package main.menu;

import main.Session;
import main.User;
import main.account.BankAccount;
import java.util.Scanner;

public class AccountSettings {
    public static void showMenu() {
        User currentUser = Session.getCurrentUser();
        BankAccount currentAccount = Session.getCurrentAccount();
        String operation = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(currentUser.getUserName() + ", \n" +
                    "Выберите операцию со счётом из списка: \n" +
                    "1. Пополнить счёт \n" +
                    "2. Снять деньги со счёта \n" +
                    "3. История операций \n" +
                    "4. Закрыть счёт \n" +
                    "5. Назад");
            operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("На какую сумму вы хотите пополнить счёт?");
                    currentAccount.deposit(Double.parseDouble(scanner.nextLine()));
                    break;
                case "2":
                    System.out.println("Какую сумму вы хотите списать со счёта?");
                    currentAccount.withdraw(Double.parseDouble(scanner.nextLine()));
                    break;
                case "3":
                    System.out.println(currentAccount.transactionHistory());
                    break;
                case "4":
                    currentUser.closeAccount(currentAccount);
                    Session.clearAccountSession();
                    return;
                case "5":
                    Session.clearAccountSession();
                    break;
                default: System.out.println(operation + " - не является допустимым значением");
            }
        } while (!operation.equals("5"));
    }
}
