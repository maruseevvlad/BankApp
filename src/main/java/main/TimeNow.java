package main;

import main.account.SavingAccount;
import java.time.LocalDateTime;

public class TimeNow implements Runnable{
    private static LocalDateTime timeNow = LocalDateTime.now();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!SavingAccount.getUsersSavingAccounts().isEmpty()) {
                var usersSavingAccounts = SavingAccount.getUsersSavingAccounts();
                synchronized (usersSavingAccounts) {
                    usersSavingAccounts.stream()
                            .forEach(e -> e.addPercentages(10));
                }
            }
        }
    }

    public static LocalDateTime getTimeNow() {
        return timeNow;
    }
}
