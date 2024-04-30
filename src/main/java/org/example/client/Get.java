package org.example.client;

import okhttp3.Response;
import java.io.IOException;

public class Get implements Request{

    public String get(String path) throws Exception{

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(baseUrl + path)
                .addHeader("Content-Type", "application/json")
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

//    public String post(String path) throws Exception{
//        RequestBody
//        okhttp3.Request request = new okhttp3.Request.Builder()
//                .url(baseUrl + path)
//                .post()
//    }
}