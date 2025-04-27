package main.account;

import main.Engine;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Set;

public class SavingAccount extends BankAccount{
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    private LocalDateTime openDate;
    private Double minimalMonthBallance;
    private static List<SavingAccount> usersSavingAccounts = new ArrayList<>();

    public SavingAccount(double balance) {
        this.accountNumber = Engine.generateAccount("SA");
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.openDate = LocalDateTime.now();
        usersSavingAccounts.add(this);
        System.out.println("Счёт " + accountNumber + " открыт. Начальный балланс: " + balance);
    }

    public void addPercentages(int percent) {
        if (balance > 0.0) {
            double oldBalance = balance;
            double multiplier = 1 + percent / 100.0;
            balance = Math.round(balance * multiplier * 100.0) / 100.0;
            double percentages = balance - oldBalance;
//            System.out.println("На счёт начислены проценты по минимальному 20 секундному остатку на сумму: "
//                    + percentages + "\n"
//                    + "Текущий баланс: " + balance);
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
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Списание", amount));
            System.out.println("Со счёта: " + accountNumber + " списано " + amount);
            minimalMonthBallance = balance;
            return true;
        }
        System.out.println("На счёте недостаточно средств.");
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

    public Double getMinimalMonthBallance() {
        return minimalMonthBallance;
    }

    public void setMinimalMonthBallance(Double minimalMonthBallance) {
        this.minimalMonthBallance = minimalMonthBallance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public static List<SavingAccount> getUsersSavingAccounts() {
        return usersSavingAccounts;
    }
}
