package main.account;

import java.util.List;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract String transactionHistory();

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}

