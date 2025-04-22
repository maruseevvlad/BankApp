package main;

import lombok.Data;
import java.util.List;

@Data
public abstract class BankAccount {
    private String accountNumber;
    private double accountBalance;
    private List<String> accountOperationHistory;
}
