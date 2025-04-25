package main;
import main.account.BankAccount;
import main.account.CheckingAccount;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user = new User("maruseev", "1111");
        user.addCheckingAccount();
        System.out.println(user.toString());

        BankAccount userAccount = user.getUserBankAccounts().get(0);
        userAccount.deposit(100);
        userAccount.withdraw(50);

        System.out.println(user.toString());
    }
}