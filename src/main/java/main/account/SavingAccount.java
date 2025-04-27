package main.account;

import main.Engine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class SavingAccount extends BankAccount{
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    private LocalDateTime openDate;

    public SavingAccount(double balance) {
        this.accountNumber = Engine.generateAccount("SA");
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.openDate = LocalDateTime.now();
    }

    public void addPercentages(int percent) {
        if (balance > 0.0) {
            double oldBalance = balance;
            double multiplier = 1 + percent / 100.0;
            balance = Math.round(balance * multiplier * 100.0) / 100.0;
            double percentages = balance - oldBalance;
            System.out.println("На счёт начислены проценты по текущему остатку на сумму: "
                    + percentages + "\n"
                    + "Текущий баланс: " + balance);  // Исправлена опечатка в слове "баланс"
            transactions.add(new Transaction("Начисление процентов", percentages));
        }
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
