package org.example.client;


public class ApiServises {
    private final Request request = new Request();

    public String getOffsetNews(){
        try{
            return request.get("/news/news?start=0&end=10");
        } catch (Exception error){
            error.printStackTrace();
            return "Error";
        }
    }
}