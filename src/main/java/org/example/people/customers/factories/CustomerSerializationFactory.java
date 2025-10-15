package org.example.people.customers.factories;

import org.example.people.customers.serialization.CustomerXmlSerialization;

public class CustomerSerializationFactory {

    public CustomerXmlSerialization create() {
        return new CustomerXmlSerialization();
    }
}
