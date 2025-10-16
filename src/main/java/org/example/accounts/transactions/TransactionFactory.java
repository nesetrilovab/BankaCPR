package org.example.accounts.transactions;

import org.example.accounts.BaseBankAccount;
import org.example.cards.Card;

import java.time.LocalDateTime;

public class TransactionFactory {

    public static Transaction createCashDeposit(BaseBankAccount account, double amount) {
        return new Transaction(Transaction.Type.DEPOSIT_CASH, account, null, amount);
    }

    public static Transaction createCashWithdrawal(BaseBankAccount account, double amount) {
        return new Transaction(Transaction.Type.WITHDRAWAL_CASH, account, null, amount);
    }

    public static Transaction createCardWithdrawal(BaseBankAccount account, Card card, double amount) {
        return new Transaction(Transaction.Type.WITHDRAWAL_CARD, account, card, amount);
    }

    // Optional: create a generic method
    public static Transaction createTransaction(Transaction.Type type, BaseBankAccount account, Card card, double amount) {
        return new Transaction(type, account, card, amount);
    }
}
