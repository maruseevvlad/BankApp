package main.account;

public class CreditCard<T extends BankAccount> extends Card<T>{
    private double creditLimit = 1000;

    @Override
    public boolean pay(double amount) {
        if (linkedAccount.getBalance() + creditLimit >= amount) {
            linkedAccount.withdraw(amount);
            return true;
        }
        return false;
    }
}
