package main;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private List<BankAccount> bankAccounts;
}
