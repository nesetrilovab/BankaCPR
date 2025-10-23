package org.example.accounts.transactions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Singleton
public class TransactionLogger {
    @Inject
    private final List<Transaction> transactions = new ArrayList<>();


    public void log(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("LOGGED: " + transaction);
    }


    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
