package org.example.accounts.services.observers;

public interface Observer {
    void update();
    void setSubject(Subject subject);
}
