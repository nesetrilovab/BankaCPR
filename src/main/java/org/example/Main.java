package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.example.accounts.serialization.MapperFactory;
import org.example.accounts.serialization.XmlMapperFactory;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
            }
        });
        App app = injector.getInstance(App.class);
        app.run();
    }
}
