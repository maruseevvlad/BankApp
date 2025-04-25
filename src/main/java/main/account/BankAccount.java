package main;
import lombok.Data;


public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);


}

