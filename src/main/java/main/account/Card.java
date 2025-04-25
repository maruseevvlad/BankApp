package main.account;

public abstract class Card<T extends BankAccount> {
    protected String cardNumber;
    protected  T linkedAccount;

    public abstract boolean pay(double amount);
}
