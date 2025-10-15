package org.example.accounts.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMapperFactory {
    public ObjectMapper getMapper() {
        return new XmlMapper();
    }
}
