package main.account;

public class CheckingAccount extends BankAccount {
    private String accountNumber;
    private double balance;

    public CheckingAccount() {
        this.accountNumber = generateRandomDigits();
        this. balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.accountNumber + " " + this.balance;
    }
}
