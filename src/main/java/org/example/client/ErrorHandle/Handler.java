package org.example.client.ErrorHandle;
import com.google.gson.JsonObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class Handler {

    public static class Connection{
        public static void getError(Exception e) throws Exception {
            if (e instanceof SocketTimeoutException) {
                throw new Exception("Connection timeout occurred", e);
            } else if (e instanceof ConnectException) {
                throw new Exception("Failed to connect to the server", e);
            }
        }
    }

    public static class Response{
        public static void getError(JsonObject response) throws Exception{
            if (response.has("Error")){
                throw new Exception(response.get("Error").getAsString());
            }
        }
    }
}
