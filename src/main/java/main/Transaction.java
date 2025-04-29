package main;

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

    public Transaction(String operationType) {
        this.operationType = operationType;
        this.dateTime = dateTimeFormatter();
        this.amount = null;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        return String.format(
                "Тип операции: %s; Сумма: %s; Дата и время: %s" + "\n",
                operationType,
                (amount != null ? amount : "Отсутствует"),
                dateTime
        );
    }
}
