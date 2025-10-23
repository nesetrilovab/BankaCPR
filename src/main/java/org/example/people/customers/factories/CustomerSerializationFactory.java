package org.example.people.customers.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.people.customers.serialization.CustomerXmlSerialization;
@Singleton
public class CustomerSerializationFactory {
    @Inject
    public CustomerXmlSerialization create() {
        return new CustomerXmlSerialization();
    }
}
