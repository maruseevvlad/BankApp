package main.account;


import java.awt.image.PackedColorModel;
import java.util.List;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

