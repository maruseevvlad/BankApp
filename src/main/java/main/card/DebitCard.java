package main.card;

import main.Engine;
import main.Session;
import main.Transaction;
import main.account.BankAccount;

public class DebitCard<T extends BankAccount> extends Card<T> {
    private String cardNumber;
    private String cardPin;
    private  T linkedAccount;

    public DebitCard(String cardPin) {
        this.cardNumber = Engine.generateAccount("DC", Engine.getCARDNUMBERLENGTH());
        this.cardPin = cardPin;
        this.linkedAccount = (T) Session.getCurrentAccount();
        Card.getAccountCards().put(cardNumber, this);
        System.out.println("Дебетовая карта " + cardNumber + " открыта и привязана к счёту " + linkedAccount.getAccountNumber());
    }
    @Override
    public boolean pay(double amount, String cardPin) {
        if (linkedAccount.getBalance() >= amount && cardPin.equals(this.getCardPin())) {
            linkedAccount.getTransactions().add(new Transaction("Списание", amount));
            System.out.println("Со счёта: " + linkedAccount.getAccountNumber() + " списано " + amount);
            return linkedAccount.withdraw(amount);
        }
        System.out.println("На счёте недостаточно средств.");
        return false;
    }

    public String getCardPin() {
        return cardPin;
    }

    @Override
    public String toString(){
        return this.cardNumber;
    }
}
