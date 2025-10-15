package org.example.people.customers.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.accounts.factories.GsonFactory;
import org.example.accounts.serialization.Serialization;
import org.example.people.customers.Customer;

public class CustomerGsonSerialization implements Serialization {
    @Override
    public String serialize(Object customer) throws JsonSyntaxException {
        if (!(customer instanceof Customer)) {
            throw new RuntimeException("Customer object is not of type Customer");
        }



        GsonFactory gsonFactory = new GsonFactory();
        Gson gson = gsonFactory.createGson();
        return gson.toJson(customer);
    }

    @Override
    public Customer deserialize(String serializedObject) throws JsonSyntaxException {


        GsonFactory gsonFactory = new GsonFactory();
        Gson  gson = gsonFactory.createGson();
        return gson.fromJson(serializedObject, Customer.class);
    }
}
