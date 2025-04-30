package main.account;

import main.Transaction;
import main.card.Card;

import java.util.List;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;
    protected List<Card> cards;

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract String transactionHistory();
    public abstract void addDebitCard(String cardPin);
    public abstract void addCreditCard(String cardPin);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Card> getCards() {
        return cards;
    }
}

