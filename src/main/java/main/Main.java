package main;
import main.account.BankAccount;
import main.account.CheckingAccount;
import main.account.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user = new User("maruseev", "1111");
        user.addCheckingAccount();
        user.addCheckingAccount();
        System.out.println(user.toString());

        Transaction transaction = new Transaction("Пополнение", 100);
        Transaction transaction1 = new Transaction("Пополнение", 100);
        Transaction transaction2 = new Transaction("Пополнение", 100);
        System.out.println(transaction.toString());
        System.out.println(transaction1.toString());
        System.out.println(transaction2.toString());
        BankAccount userAccount = user.getUserBankAccounts().get(0);
        BankAccount userAccount1 = user.getUserBankAccounts().get(1);
        userAccount1.deposit(100);
        userAccount.deposit(100);
        userAccount.withdraw(50);

        System.out.println(user.toString());
    }
}