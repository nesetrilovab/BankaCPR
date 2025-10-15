package org.example.accounts.factories;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.serialization.BankAccountSerialization;

public class BankAccountSerializationFactory {
    public static BankAccountSerialization createBankAccount(BaseBankAccount account) {
        BankAccountSerialization serialized = new BankAccountSerialization();
        serialized.uuid = account.getUuid();
        serialized.bankAccountNumber = account.getBankAccountNumber();
        serialized.customer = account.getCustomer();
        serialized.balance = account.getBalance();
        return serialized;
    }
}
