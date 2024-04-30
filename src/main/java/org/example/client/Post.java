package org.example.client;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class Post implements Request{

    public String post(String path, String jsonBody) throws IOException {

        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonBody, JSON);

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(baseUrl + path)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
