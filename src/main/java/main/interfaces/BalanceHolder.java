package main.interfaces;

public interface BalanceHolder {
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);
}
