package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Engine {
    private static HashSet<String> usersAccounts = new HashSet<>();

    public static String generateAccount(String accountType) {
        StringBuilder sb = new StringBuilder();
        sb.append(accountType);
        do {
            for (int i = 0; i < 7; i++) {
                int digit = (int) (Math.random() * 10);
                sb.append(digit);
            }
        } while (usersAccounts.contains(sb.toString()));
        usersAccounts.add(sb.toString());
        return sb.toString();
    }

    public static String dateTimeFormatter(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }

    public static HashSet<String> getUsersAccounts() {
        return usersAccounts;
    }
}
