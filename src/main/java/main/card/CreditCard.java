package main.card;

import main.Engine;
import main.Session;
import main.Transaction;
import main.account.BankAccount;

import java.util.Scanner;

public class CreditCard<T extends BankAccount> extends Card<T> {
    private double creditLimit = 1000;
    private double credit = creditLimit;
    private String cardNumber;
    private String cardPin;
    private  T linkedAccount;

    public CreditCard(String cardPin) {
        this.cardNumber = Engine.generateAccount("CC", Engine.getCARDNUMBERLENGTH());
        this.cardPin = cardPin;
        this.linkedAccount = (T) Session.getCurrentAccount();
        Card.getAccountCards().put(cardNumber, this);
        System.out.println("Кредитная карта " + cardNumber + " открыта и привязана к счёту " + linkedAccount.getAccountNumber());
    }

    public String getCardPin() {
        return cardPin;
    }

    @Override
    public boolean pay(double amount, String cardPin) {
        if (!this.cardPin.equals(cardPin)) {
            System.out.println("Неверный PIN-код.");
            return false;
        }

        double totalAvailable = linkedAccount.getBalance() + credit;
        if (totalAvailable >= amount) {
            double balance = linkedAccount.getBalance();
            double useFromBalance = Math.min(balance, amount);
            double useFromCredit = amount - useFromBalance;
            if (useFromBalance > 0) {
                linkedAccount.withdraw(useFromBalance);
            }
            credit -= useFromCredit;
            linkedAccount.getTransactions().add(new Transaction<>("Оплата по карте " + cardNumber));
            System.out.printf("Оплата на сумму %.2f успешна. Использовано кредита: %.2f%n", amount, useFromCredit);
            return true;
        } else {
            System.out.println("Недостаточно средств на карте.");
            return false;
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String toString(){
        return this.cardNumber;
    }

    public void checkDebt() {
        double debt = getCurrentDebt();
        if (debt > 0) {
            System.out.printf("Текущая задолженность: %.2f руб.%n", debt);
            System.out.print("Хотите погасить задолженность? (да/нет): ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("да")) {
                System.out.print("Введите сумму для погашения: ");
                double amount = scanner.nextDouble();
                repayDebt(amount);
            }
        } else {
            System.out.println("Задолженность отсутствует.");
        }
    }

    public void repayDebt(double amount) {
        double debt = getCurrentDebt();

        if (amount <= 0) {
            System.out.println("Ошибка: Сумма должна быть положительной");
            return;
        }

        if (amount > debt) {
            System.out.printf("Сумма превышает задолженность. Установлено значение: %.2f%n", debt);
            amount = debt;
        }

        if (linkedAccount.getBalance() >= amount) {
            linkedAccount.withdraw(amount);
            credit += amount;
            linkedAccount.getTransactions().add(new Transaction<>("Погашение кредита карты " + cardNumber));
            System.out.printf(
                    "Успешно погашено %.2f руб. Доступный кредит: %.2f руб.%n",
                    amount,
                    credit
            );
        } else {
            System.out.println("Ошибка: Недостаточно средств на счете");
        }
    }

    public double getCurrentDebt() {
        return creditLimit - credit;
    }
}


