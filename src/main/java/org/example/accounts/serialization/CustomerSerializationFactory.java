package org.example.accounts.serialization;

public class CustomerSerializationFactory {

    public CustomerGsonSerialization create() {
        return new CustomerGsonSerialization();
    }
}
