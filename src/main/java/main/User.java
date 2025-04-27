package main;

import main.account.BankAccount;
import main.account.CheckingAccount;
import main.account.SavingAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
   private String userName;
   private String userPassword;
   private List<BankAccount> userBankAccounts;
   private static HashMap<String, User> users = new HashMap<>();

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBankAccounts = new ArrayList<BankAccount>();
        users.put(userName, this);
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    @Override
    public String toString(){
        return this.userName + " " + this.userPassword + " " + this.userBankAccounts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<BankAccount> getUserBankAccounts() {
        return userBankAccounts;
    }

    public void setUserBankAccounts(List<BankAccount> userBankAccounts) {
        this.userBankAccounts = userBankAccounts;
    }

    public void addCheckingAccount() {
        this.userBankAccounts.add(new CheckingAccount());
        System.out.println();
    }

    public void addSavingAccount(double balance) {
        this.userBankAccounts.add(new SavingAccount(balance));
    }

    public void closeAccount(BankAccount bankAccount) {
        userBankAccounts.remove(bankAccount);
        //Удаление аккаунта из списка с номерами аккаунтов всех пользователей.
        Engine.getUsersAccounts().remove(bankAccount.getAccountNumber());
        System.out.println("Счёт: " + bankAccount.getAccountNumber() + " успешно удален.");
    }

}
