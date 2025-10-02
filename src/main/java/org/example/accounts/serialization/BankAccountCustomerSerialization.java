package org.example.accounts.serialization;

import org.example.people.customers.Customer;
import org.gradle.internal.impldep.com.google.gson.Gson;

public class BankAccountCustomerSerialization implements Serialization{
    public String uuid; //this class should be ok & do in xml??? pospojovat se stringem a nají knihovnu co tu serializaci udělá za mě
    public String firstName;
    public String lastName;
@Override public String serialization(Object customer){
    if(!(customer instanceof Customer)){
        throw new RuntimeException("Customer object is not of type Customer");
    }


    BankAccountCustomerSerialization bankAccountCustomerSerialization = BankAccountCustomerSerializationFactory.createBankAccountCustomerSerialization(customer);
//    StringBuilder sb = new StringBuilder();
//    sb.append("{");
//    sb.append("\"uuid\":\"" + bankAccountCustomerSerialization.uuid + "\",");
//    sb.append("\"firstName\":\"" + bankAccountCustomerSerialization.firstName + "\",");
//    sb.append("\"lastName\":\"" + bankAccountCustomerSerialization.lastName + "\"");
//    sb.append("}");
    Gson gson = new Gson();
    String json = gson.toJson(bankAccountCustomerSerialization);
    return json;
}
    @Override
    public Object deserialization(Object serializedObject) {
    return null; //gson.fromJson("", Customer.class);

    }
}
