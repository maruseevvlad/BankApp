package main.account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import main.Engine;

public class CheckingAccount extends BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public CheckingAccount() {
        this.accountNumber = Engine.generateAccount("CA");
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
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Списание", amount));
            System.out.println("Со счёта: " + accountNumber + " списано " + amount);
            return true;
        }
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

//    public String transactionHistory(){
//        return "Операции по счёту "
//                + accountNumber + ":\n"
//                + transactions.stream()
//                .sorted(Comparator.comparing(Transaction::getDateTime))
//                .collect(Collectors.toList());
//    }

    @Override
    public String toString(){
        return this.accountNumber + " " + this.balance;
    }
}
