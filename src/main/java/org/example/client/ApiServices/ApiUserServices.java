package org.example.client.ApiServices;

import org.example.client.dto.FavoriteNewsDTO;
import org.example.client.dto.UserDTO;

public class ApiUserServices implements ApiServices {

    public UserDTO getUserById(String user_id) throws Exception{
        try{
            return gson.fromJson(getRequest.get("/users/get_by_id/%s".formatted(user_id)), UserDTO.class);
        } catch (Exception error){
            throw new Exception(String.format("Failed to get user by id: %s", user_id), error);
        }
    }
    public UserDTO[] getAllUsers() throws Exception {
        try{
            return gson.fromJson(getRequest.get("/users/get_all"), UserDTO[].class);
        } catch (Exception error){
            throw new Exception("Failed to get users", error);
        }
    }

    public FavoriteNewsDTO[] getFavoriteNews(String user_id) throws Exception{
        try {
            return gson.fromJson(getRequest.get(String.format("/users/get_favorite_news?user_id=%s&start=0&end=10", user_id)), FavoriteNewsDTO[].class);
        } catch (Exception error) {
            throw new Exception("Failed to get favorite news", error);
        }
    }

    public UserDTO addUser(String login, String email, String password) throws Exception{
        try{
            return gson.fromJson(postRequest.post("/users/register", String.format("""
                    {
                      "login": "%s",
                      "email": "%s",
                      "password": "%s",
                      "rights": "user"
                    }""", login, email, password)), UserDTO.class);
        } catch (Exception error){
            throw new Exception("Failed to add user", error);
        }
    }

    public FavoriteNewsDTO addFavoriteNews(String user_id, String news_id) throws Exception{
        try {
            return gson.fromJson(postRequest.post("/users/add_favorite_news", String.format("""
                    {
                      "user_id": "%s",
                      "news_id": "%s"
                    }""", user_id, news_id)), FavoriteNewsDTO.class);
        } catch(Exception error){
            throw new Exception("Failed to add favorite news", error);
        }
    }

    public String deleteFavoriteNews(String user_id, String news_id) throws Exception{
        try {
            return deleteRequest.delete(String.format("/users/delete_favorite_news?user_id=%s&news_id=%s", user_id, news_id));
        } catch (Exception error){
            throw new Exception("Failed to delete favorite news", error);
        }
    }

    public String deleteAllFavoriteNews(String user_id) throws Exception{
        try {
            return deleteRequest.delete(String.format("/users/delete_all_favorite_news?user_id=%s", user_id));
        } catch (Exception error){
            throw new Exception("Failed to delete all favorite", error);
        }
    }
}
