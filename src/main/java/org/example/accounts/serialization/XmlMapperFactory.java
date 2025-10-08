package org.example.accounts.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMapperFactory {
    public ObjectMapper getMapper() {
        return new XmlMapper();
    }
}
