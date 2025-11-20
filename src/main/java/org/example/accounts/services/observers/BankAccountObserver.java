package org.example.accounts.services.observers;

public class BankAccountObserver implements Observer{
    private Subject subject;
private Observer observer;
    @Override
    public void update() {
        String event = (String) subject.getUpdate(observer);
        System.out.println("[OBSERVER] Event received: " + event);
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
