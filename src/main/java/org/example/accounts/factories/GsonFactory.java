package org.example.accounts.factories;

import com.google.gson.GsonBuilder;

public class GsonFactory {
    public com.google.gson.Gson createGson() {
        return new GsonBuilder().create();
    }
}
