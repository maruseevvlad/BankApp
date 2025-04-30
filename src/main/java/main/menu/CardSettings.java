package main.menu;

import main.Session;
import main.User;
import main.card.Card;
import java.util.Scanner;


public class CardSettings {
    public static void showMenu() {
        User currentUser = Session.getCurrentUser();
        Card currentCard = Session.getCurrentCard();
        String operation = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(currentUser.getUserName() + ", \n" +
                    "Выберите операцию с картой из списка: \n" +
                    "1. Провести оплату картой \n" +
                    "2. Пополнить кредитный лимит \n" +
                    "2. Назад");
            operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Введите сумму оплаты");
                    var amount = scanner.nextLine();
                    System.out.println("Введите пин код");
                    var pin = scanner.nextLine();
                    currentCard.pay(Double.parseDouble(amount), pin);
                    break;
                case "2":
                    if (currentCard.getCardNumber().startsWith("DC")) {
                        System.out.println("Пополнить лимит можно только у кредитной карты");
                        break;
                    }
                    currentCard.repayDebt();
                    break;
                case "3":
                    Session.clearCardSession();
                    break;
                default: System.out.println(operation + " - не является допустимым значением");
            }
        } while (!operation.equals("3"));
    }
}
