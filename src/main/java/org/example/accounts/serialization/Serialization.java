package org.example.accounts.serialization;

import org.example.people.customers.Customer;

public interface Serialization {
    public String serialization(Object customer);
    public Object deserialization(Object serializedObject);
}
