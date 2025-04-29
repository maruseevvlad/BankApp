package main.card;

import main.account.BankAccount;

public class CreditCard<T extends BankAccount> extends Card<T> {
    private double creditLimit = 1000;

    @Override
    public boolean pay(double amount, String cardPin) {
        if (linkedAccount.getBalance() + creditLimit >= amount) {
            linkedAccount.withdraw(amount);
            return true;
        }
        return false;
    }
}
