package org.example.client.ApiServices;


public class ApiNewsServices implements ApiServices{

    public String getOffsetNews(){
        try{
            return getRequest.get("/news/news?start=0&end=10");
        } catch (Exception error){
            error.printStackTrace();
            return "Error";
        }
    }

    public String getNewsById(String news_id){
        try{
            return getRequest.get("/news/news/{id}?news_id=%s".formatted(news_id));
        }
        catch (Exception error){
            error.printStackTrace();
            return "Error";
        }
    }

    public String deleteNewsById(String news_id){
        try{
            return deleteRequest.delete("/");
        }
        catch (Exception error){
            error.printStackTrace();
            return "Error";
        }
    }
}