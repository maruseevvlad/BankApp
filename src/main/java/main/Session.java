package main;

import main.account.BankAccount;
import main.card.Card;

public class Session {
    private static User currentUser;
    private static BankAccount currentAccount;
    private static Card currentCard;

    public static BankAccount getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(BankAccount currentAccount) {
        Session.currentAccount = currentAccount;
    }

    public static void clearAccountSession() {
        currentAccount = null;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void clearSession() {
        currentUser = null;
    }

    public static Card getCurrentCard() {
        return currentCard;
    }

    public static void setCurrentCard(Card currentCard) {
        Session.currentCard = currentCard;
    }

    public static void clearCardSession() {
        currentCard = null;
    }
}
