package org.example.client.ApiServices;

import org.example.client.dto.NewsDTO;

public class ApiNewsServices implements ApiServices{

    public NewsDTO[] getOffsetNews() throws Exception {
        try{
            return gson.fromJson(getRequest.get("/news/news?start=0&end=10"), NewsDTO[].class);
        } catch (Exception error){
            throw new Exception("Failed to get list of news ", error);
        }
    }

    public NewsDTO getNewsById(String news_id) throws Exception {
        try{
            return gson.fromJson(getRequest.get("/news/news/{id}?news_id=%s".formatted(news_id)), NewsDTO.class);
        }
        catch (Exception error){
            throw new Exception("Failed to get news by id ", error);
        }
    }

    public String deleteNewsById(String news_id) throws Exception {
        try{
            return deleteRequest.delete("/");
        }
        catch (Exception error){
            throw new Exception("Failed to delete news by id", error);
        }
    }
}