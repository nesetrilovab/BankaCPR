package org.example.people.customers.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.people.customers.Customer;

import java.util.UUID;
@Singleton
public class CustomerFactory {
    @Inject
    public Customer createCustomer(String firstName, String lastName) {
        String uuid = UUID.randomUUID().toString();
        return new Customer(uuid, firstName, lastName);
    }
}

