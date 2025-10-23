package org.example.accounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.serialization.BankAccountSerialization;
@Singleton
public class BankAccountSerializationFactory {
    @Inject
    public BankAccountSerialization create(BaseBankAccount account) {
        BankAccountSerialization serialized = new BankAccountSerialization();
        serialized.uuid = account.getUuid();
        serialized.bankAccountNumber = account.getBankAccountNumber();
        serialized.customer = account.getCustomer();
        serialized.balance = account.getBalance();
        return serialized;
    }
}
