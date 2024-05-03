package org.example.client.ApiServices;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.client.ErrorHandle.Handler;
import org.example.client.dto.FavoriteNewsDTO;
import org.example.client.dto.UserDTO;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class ApiUserServices implements ApiServices {

    public UserDTO getUserById(String user_id) throws Exception {
        try{
            JsonObject response = JsonParser.parseString(
                    getRequest.get("/users/get_by_id/%s".formatted(user_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, UserDTO.class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }
    public UserDTO[] getAllUsers() throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    getRequest.get("/users/get_all")
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, UserDTO[].class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public FavoriteNewsDTO[] getFavoriteNews(String user_id) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    getRequest.get(String.format("/users/get_favorite_news?user_id=%s&start=0&end=10", user_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, FavoriteNewsDTO[].class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public UserDTO addUser(String login, String email, String password) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    postRequest.post("/users/register", String.format("""
                    {
                      "login": "%s",
                      "email": "%s",
                      "password": "%s",
                      "rights": "user"
                    }""", login, email, password))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, UserDTO.class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public UserDTO authenticationUser(String login, String password) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    getRequest.get(String.format("/users/authentication?login=%s&password=%s", login, password))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, UserDTO.class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public FavoriteNewsDTO addFavoriteNews(String user_id, String news_id) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    postRequest.post("/users/add_favorite_news", String.format("""
                    {
                      "user_id": "%s",
                      "news_id": "%s"
                    }""", user_id, news_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return gson.fromJson(response, FavoriteNewsDTO.class);

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public String deleteFavoriteNews(String user_id, String news_id) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    deleteRequest.delete(String.format("/users/delete_favorite_news?user_id=%s&news_id=%s", user_id, news_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return response.get("Successful").toString();

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }

    public String deleteAllFavoriteNews(String user_id) throws Exception {
        try {
            JsonObject response = JsonParser.parseString(
                    deleteRequest.delete(String.format("/users/delete_all_favorite_news?user_id=%s", user_id))
            ).getAsJsonObject();

            Handler.Response.getError(response);
            return response.get("Successful").toString();

        } catch (SocketTimeoutException | ConnectException error) {
            Handler.Connection.getError(error);
        } catch (Exception error){
            throw error;
        }
        throw new IllegalStateException("Unexpected state: unable to authenticate user");
    }
}
