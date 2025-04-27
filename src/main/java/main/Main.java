package main;
import main.account.BankAccount;
import main.account.CheckingAccount;
import main.account.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static TimeNow timeNow;
    public static void main(String[] args) {
        timeNow = new TimeNow();
        Thread threadTime = new Thread(timeNow);
        threadTime.setDaemon(true);
        threadTime.start();

//        Thread appLive = new Thread(timeNow);
//        appLive.setDaemon(true);
//        appLive.start();
//        System.out.println(timeNow);

        User user = new User("maruseev", "1111");
        user.addCheckingAccount();
        user.addSavingAccount();
        System.out.println(user);

        BankAccount userAccount1 = user.getUserBankAccounts().get(0);
        BankAccount userAccount2 = user.getUserBankAccounts().get(1);
        userAccount1.deposit(1000);
        userAccount1.withdraw(100);




        System.out.println(userAccount1.transactionHistory());

        user.closeAccount(userAccount1);
        System.out.println(user);
    }
}