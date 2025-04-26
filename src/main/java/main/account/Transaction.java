package main.account;

import java.time.LocalDateTime;

import static main.Engine.dateTimeFormatter;

public class Transaction<T extends Number> {
    private String operationType;
    private T amount;
    private String dateTime;

    public Transaction(String operationType, T amount) {
        this.operationType = operationType;
        this.amount = amount;
        this.dateTime = dateTimeFormatter();
    }

    @Override
    public String toString() {
        return "Тип операции: '" + operationType + '\'' +
                ", Сумма: " + amount +
                ", Дата и время: " + dateTime + " | ";
    }
}
