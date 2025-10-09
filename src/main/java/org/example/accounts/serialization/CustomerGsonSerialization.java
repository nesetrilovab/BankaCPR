package org.example.accounts.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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
