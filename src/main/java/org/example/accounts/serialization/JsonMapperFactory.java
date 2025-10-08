package org.example.accounts.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonMapperFactory extends MapperFactory {
    @Override
    public ObjectMapper getMapper() {
        return new JsonMapper();
    }
}
