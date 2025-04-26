package main.account;

import main.Engine;

import java.util.ArrayList;
import java.util.List;

public class SavingAccount extends BankAccount{
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public SavingAccount() {
        this.accountNumber = Engine.generateAccount("SA");
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Пополнение", amount));
        System.out.println("Счёт: " + accountNumber + " успешно пополнен на " + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public String transactionHistory() {
        return "Операции по счёту "
                + accountNumber + ":\n"
                + transactions.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }

    public String toString(){
        return this.accountNumber + " " + this.balance;
    }
}
