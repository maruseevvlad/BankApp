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
        user.addSavingAccount();
        System.out.println(user);

        BankAccount userAccount1 = user.getUserBankAccounts().get(0);
        BankAccount userAccount2 = user.getUserBankAccounts().get(1);
        userAccount1.deposit(1000.5);
        userAccount1.withdraw(50);

        System.out.println(userAccount1.transactionHistory());

        user.closeAccount(userAccount1);
        System.out.println(user);
    }
}