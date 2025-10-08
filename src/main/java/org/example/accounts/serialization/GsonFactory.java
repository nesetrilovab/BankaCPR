package org.example.accounts.serialization;

import com.google.gson.GsonBuilder;

public class GsonFactory {
    public com.google.gson.Gson createGson() {
        return new GsonBuilder().create();
    }
}
