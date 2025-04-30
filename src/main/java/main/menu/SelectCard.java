package main.menu;

import main.Session;
import main.account.BankAccount;

import java.util.List;
import java.util.Scanner;

public class SelectCard {
    public static void showMenu() {
        BankAccount currentAccount = Session.getCurrentAccount();
        String operation = "";

        do {
            if (currentAccount.getCards().isEmpty()) {
                System.out.println("На данный момент у вас нет карт");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("С какой картой вы хотите продолжить работать: \n" +
                    "Для выхода введите 'exit'");
            showBankCards();
            operation = scanner.nextLine();

            if ("exit".equalsIgnoreCase(operation)) {
                Session.clearCardSession();
                break;
            }

            if (hasIndex(currentAccount.getCards(), Integer.parseInt(operation) - 1)) {
                Session.setCurrentCard(currentAccount.getCards().get(Integer.parseInt(operation) - 1));
                CardSettings.showMenu();
            } else {
                System.out.println(operation + " - не является допустимым значением");
            }
        } while (true);
    }

    public static void showBankCards() {
        var bankCards = Session.getCurrentAccount().getCards();
        var j = 1;
        for (var i = 0; i < bankCards.size(); i++){
            System.out.println(j + ". " + bankCards.get(i) + Session.getCurrentAccount().getBalance());
            j++;
        }
    }

    public static boolean hasIndex(List<?> list, int n) {
        return list != null && n >= 0 && n < list.size();
    }
}
