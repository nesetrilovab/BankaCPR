package org.example.people.customers.factories;

import org.example.people.customers.Customer;

import java.util.UUID;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName) {
        String uuid = UUID.randomUUID().toString();
        return new Customer(uuid, firstName, lastName);
    }
}
