package main.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.Engine;
import main.Transaction;
import main.User;
import main.card.Card;
import main.card.DebitCard;

public class CheckingAccount extends BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    private List<Card> cards;

    public CheckingAccount() {
        this.accountNumber = Engine.generateAccount("CA", Engine.getACCOUNTNUMBERLENGTH());
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        System.out.println("Счёт " + accountNumber + " открыт.");
        this.transactions.add(new Transaction<>("Открытие счёта"));
        this.cards = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Пополнение", amount));
        System.out.println("Счёт: " + accountNumber + " успешно пополнен на " + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Списание", amount));
            System.out.println("Со счёта: " + accountNumber + " списано " + amount);
            return true;
        }
        System.out.println("На счёте недостаточно средств.");
        return false;
    }

    public String transactionHistory(){
        return "Операции по счёту "
                + accountNumber + ":\n"
                + transactions.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }

    @Override
    public String toString(){
        return this.accountNumber + " " + this.balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addDebitCard(String cardPin) {
        this.cards.add(new DebitCard(cardPin));
        transactions.add(new Transaction<>("Привязка карты " + cards.getLast()));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
