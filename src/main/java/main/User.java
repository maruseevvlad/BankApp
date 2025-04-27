package main;

import main.account.BankAccount;
import main.account.CheckingAccount;
import main.account.SavingAccount;
import java.util.ArrayList;
import java.util.List;

public class User {
   private String userName;
   private String userPassword;
   private List<BankAccount> userBankAccounts;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBankAccounts = new ArrayList<BankAccount>();
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
    }

    public void addSavingAccount() {
        this.userBankAccounts.add(new SavingAccount());
    }

    public void closeAccount(BankAccount bankAccount) {
        userBankAccounts.remove(bankAccount);
        //Удаление из списка с номерами аккаунтов всех пользователей.
        Engine.getUsersAccounts().remove(bankAccount.getAccountNumber());
    }

}
