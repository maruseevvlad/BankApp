package main.account;

public class DebitCard<T extends BankAccount> extends Card<T>{

    @Override
    public boolean pay(double amount) {
        if (linkedAccount.getBalance() >= amount) {
            return linkedAccount.withdraw(amount);
        }
        return false;
    }
}
