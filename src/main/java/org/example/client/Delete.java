package org.example.client;

import okhttp3.Response;
import java.io.IOException;

public class Delete implements Request{

    public String delete(String path) throws IOException {

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(baseUrl + path)
                .addHeader("Content-Type", "application/json")
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
    }
}
