package org.example.accounts.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Serialization {
    public String serialize(Object customer) throws JsonProcessingException;
    public Object deserialize(String serializedObject) throws JsonProcessingException;
}
