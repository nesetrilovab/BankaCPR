package org.example.accounts.serialization;

import org.example.accounts.BaseBankAccount;

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
