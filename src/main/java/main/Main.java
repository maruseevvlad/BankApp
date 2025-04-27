package main;
import main.account.BankAccount;
import main.account.SavingAccount;


public class Main {
    static TimeNow timeNow;
    public static void main(String[] args) {
        timeNow = new TimeNow();
        Thread threadTime = new Thread(timeNow);
        threadTime.setDaemon(true);
        threadTime.start();

        User user = new User("maruseev", "1111");
//        user.addCheckingAccount();
        user.addSavingAccount(100);
        System.out.println(user);

//        BankAccount CA = user.getUserBankAccounts().get(0);
        SavingAccount SA = (SavingAccount) user.getUserBankAccounts().get(0);
//        CA.deposit(1000);
//        CA.withdraw(100);

        SA.deposit(100);
        SA.addPercentages(10);




        System.out.println(SA.transactionHistory());

        user.closeAccount(SA);
        System.out.println(user);
    }
}