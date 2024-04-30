package org.example.client;

import okhttp3.OkHttpClient;

public interface Request {
    OkHttpClient client = new OkHttpClient();
    String baseUrl = "http://192.168.1.186:8000";
}
