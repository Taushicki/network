package org.example.client;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class Post implements Request{

    public String post(String jsonBody) throws IOException {

        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonBody, JSON);

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(baseUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
//        {
//            "user_id_id": "cf48fa60-d073-48b4-8d88-1320da68019f",
//                "news_id_id": "662eb44d9a794712c3837859",
//                "id": "ed1b7236-c681-4cf4-92f5-4385223da8b9"
//        }
    }
}
