package org.example.accounts.transactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionLogger {
    private final List<Transaction> transactions = new ArrayList<>();


    public void log(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("LOGGED: " + transaction);
    }


    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
