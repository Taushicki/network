package org.example.client.dto;

public class FavoriteNewsDTO {
    private final String id;
    private final String user_id;
    private final String news_id;

    public FavoriteNewsDTO(String id, String user_id, String news_id){
        this.id = id;
        this.user_id = user_id;
        this.news_id = news_id;
    }

    public String getId() { return id; }

    public String getUserId() { return user_id; }

    public String getNewsId() { return news_id; }
}
