package main.menu;

import main.Session;
import main.account.BankAccount;

import java.util.Scanner;

public class AddCard {
    public static void showMenu() {
        BankAccount currentAccount = Session.getCurrentAccount();
        String operation = "";

        do {
            if (currentAccount.getAccountNumber().startsWith("SA")) {
                System.out.println("К сберегательному счёту нельзя привязать карту");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Какую карту вы хотите открыть? \n" +
                    "1. Дебетовую \n" +
                    "2. Кредитную \n" +
                    "3. Назад \n");
            operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Введите пин код для новой карты");
                    currentAccount.addDebitCard(scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Введите пин код для новой карты");
                    currentAccount.addCreditCard(scanner.nextLine());
                    break;
                case "3":
                    return;
                default:
                    System.out.println(operation + " - не является допустимым значением");
            }
        } while (true);
    }
}
