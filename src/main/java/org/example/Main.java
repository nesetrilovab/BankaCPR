package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Injector injector = Guice.createInjector(new BankInjector());
        App app = injector.getInstance(App.class);
        app.run();

    }
}
