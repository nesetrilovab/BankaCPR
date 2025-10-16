package org.example.people.customers;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Customer {
    @JacksonXmlProperty(localName = "uuid")
    private String uuid;
    @JacksonXmlProperty(localName = "firstName")
    private String firstName;
    @JacksonXmlProperty(localName = "lastName")
    private String lastName;

    public Customer(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Customer() {}
    // Getters
    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
