package org.example.accounts.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonMapperFactory {
    public ObjectMapper getMapper() {
        return new JsonMapper();
    }
}
