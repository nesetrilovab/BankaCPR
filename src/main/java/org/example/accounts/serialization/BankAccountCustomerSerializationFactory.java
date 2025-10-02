package org.example.accounts.serialization;

import org.example.people.customers.Customer;

public class BankAccountCustomerSerializationFactory {
    public static BankAccountCustomerSerialization createBankAccountCustomerSerialization(Object obj) {
        if (!(obj instanceof Customer customer)) {
            throw new RuntimeException("Expected a Customer object");
        }

        BankAccountCustomerSerialization serialized = new BankAccountCustomerSerialization();
        serialized.uuid = customer.getUuid();
        serialized.firstName = customer.getFirstName();
        serialized.lastName = customer.getLastName();
        return serialized;
    }

    //some file reading missing here i think
}
