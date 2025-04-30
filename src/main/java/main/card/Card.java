package main.card;

import main.account.BankAccount;

import java.util.HashMap;

public abstract class Card<T extends BankAccount> {
    protected String cardNumber;
    protected String cardPin;
    protected  T linkedAccount;
    private static HashMap<String, Card> accountCards = new HashMap<>();
    protected double creditLimit;

    public abstract boolean pay(double amount, String cardPin);

    public boolean checkPin(String pin) {
        return pin.equals(this.cardPin);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public T getLinkedAccount() {
        return linkedAccount;
    }

    public static HashMap<String, Card> getAccountCards() {
        return accountCards;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void repayDebt() {
    }
}
