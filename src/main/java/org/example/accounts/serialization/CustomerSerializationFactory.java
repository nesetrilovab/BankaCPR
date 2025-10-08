package org.example.accounts.serialization;

import com.google.inject.Inject;

public class CustomerSerializationFactory {

    public CustomerSerialization create() {
        return new CustomerSerialization();
    }
}
