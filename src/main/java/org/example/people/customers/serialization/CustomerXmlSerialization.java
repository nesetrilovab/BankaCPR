package org.example.people.customers.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.factories.JsonMapperFactory;
import org.example.accounts.serialization.Serialization;
import org.example.people.customers.Customer;

public class CustomerXmlSerialization implements Serialization {
    @Override
    public String serialize(Object customer) throws JsonProcessingException {
        if (!(customer instanceof Customer)) {
            throw new RuntimeException("Customer object is not of type Customer");
        }


        ObjectMapper objectMapper = (new JsonMapperFactory()).getMapper();

        return objectMapper.writeValueAsString(customer);

    }
    @Override
    public Customer deserialize(String serializedObject) throws JsonProcessingException {
        ObjectMapper objectMapper = (new JsonMapperFactory()).getMapper();
        return objectMapper.readValue(serializedObject, Customer.class);


    }
}
