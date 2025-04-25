package main.account;

public class SavingAccount extends BankAccount{
    @Override
    public void deposit(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
