package org.example.accounts.services.observers;

import java.util.ArrayList;
import java.util.List;

public class BankAccountSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private String lastEvent;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
        observer.setSubject(this);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return lastEvent;
    }


}
