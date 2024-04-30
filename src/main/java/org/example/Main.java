package org.example;

import com.google.gson.Gson;
import org.example.client.ApiServices.ApiNewsServices;
import org.example.client.ApiServices.ApiUserServices;
import org.example.client.dto.NewsDTO;

public class Main {
    public static void main(String[] args) {
        ApiNewsServices api = new ApiNewsServices();
        ApiUserServices user_api = new ApiUserServices();
        Gson gson = new Gson();
        NewsDTO[] newsArray = gson.fromJson(api.getOffsetNews(), NewsDTO[].class);
        for (NewsDTO news: newsArray){
            System.out.println(news.getTitle());
        }

        System.out.println(api.getNewsById("662e129f9a7947c6c8b12ad4"));

    }
}