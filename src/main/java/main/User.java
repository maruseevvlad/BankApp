package main;

import main.account.BankAccount;
import main.account.CheckingAccount;
import main.account.SavingAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class User {
   private String userName;
   private String userPassword;
   private List<BankAccount> userBankAccounts;
   private static HashMap<String, User> users = new HashMap<>();

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = hashPassword(userPassword);
        this.userBankAccounts = new ArrayList<>();
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

    public List<BankAccount> getUserBankAccounts() {
        return userBankAccounts;
    }

    public void addCheckingAccount() {
        List<String> userAccountsNumbers = this.getUserBankAccounts().stream()
                .map(e -> e.getAccountNumber())
                .filter(e -> e.startsWith("CA"))
                .toList();
        if (userAccountsNumbers.isEmpty()) {
            this.userBankAccounts.add(new CheckingAccount());
        } else {
            System.out.println("У вас уже открыт лицевой счёт.");
        }
    }

    public void addSavingAccount(double balance) {
        List<String> userAccountsNumbers = this.getUserBankAccounts().stream()
                .map(e -> e.getAccountNumber())
                .filter(e -> e.startsWith("SA"))
                .toList();

        if (userAccountsNumbers.size() <= 1) {
            this.userBankAccounts.add(new SavingAccount(balance));
        } else {
            System.out.println("У вас достигнут лимит по сберегательным счетам.");
        }
    }

    public void closeAccount(BankAccount bankAccount) {
        if (bankAccount.getBalance() > 0) {
            System.out.println("Снимите или переведите все денежные средства для закрытия счёта.");
        } else {
            userBankAccounts.remove(bankAccount);
            //Удаление аккаунта из списка с номерами аккаунтов всех пользователей.
            Engine.getUsersAccounts().remove(bankAccount.getAccountNumber());
            System.out.println("Счёт: " + bankAccount.getAccountNumber() + " успешно удален.");
        }
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String plainTextPassword, User user) {
        return BCrypt.checkpw(plainTextPassword, user.getPasswordHash());
    }

    public String getPasswordHash() {
        return userPassword;
    }
}
