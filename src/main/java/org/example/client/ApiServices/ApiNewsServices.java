package org.example.client.ApiServices;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.client.ErrorHandle.Handler;
import org.example.client.dto.NewsDTO;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class ApiNewsServices implements ApiServices{

    public NewsDTO[] getOffsetNews() throws Exception {
        try{
            JsonObject response = JsonParser.parseString(
                    getRequest.get("/news/news?start=0&end=10")
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, NewsDTO[].class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error) {
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public NewsDTO getNewsById(String news_id) throws Exception {
        try{
            JsonObject response = JsonParser.parseString(
                    getRequest.get("/news/news/{id}?news_id=%s".formatted(news_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, NewsDTO.class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error) {
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public String deleteNewsById(String news_id) throws Exception {
        try{
            JsonObject response = JsonParser.parseString(
                    deleteRequest.delete("/")
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return response.get("Successful").toString();

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error) {
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }
}