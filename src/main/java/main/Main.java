package main;
import main.menu.MainMenu;


public class Main {
    static TimeNow timeNow;
    public static void main(String[] args) {
        timeNow = new TimeNow();
        Thread threadTime = new Thread(timeNow);
        threadTime.setDaemon(true);
        threadTime.start();

        MainMenu.showMenu();
    }


}





//User user = new User("maruseev", "1111");
////        user.addCheckingAccount();
//            user.addSavingAccount(100);
//
////        BankAccount CA = user.getUserBankAccounts().get(0);
//            SavingAccount SA = (SavingAccount) user.getUserBankAccounts().get(0);
////        CA.deposit(1000);
////        CA.withdraw(100);
////            SA.withdraw(50);
////        user.closeAccount(SA);
//            System.out.println(user);
////        System.out.println("Список всех аккаунтов " + Engine.getUsersAccounts());
//
//            System.out.println("Для выхода нажми 0");
//            Scanner scanner = new Scanner(System.in);
//            operation = scanner.nextInt();