package main.account;


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

    public static String generateRandomDigits() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }
}

