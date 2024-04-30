package org.example.client.dto;

public class NewsDTO {
    private final String news_id;
    private final String title;
    private final String link;
    private final String img;
    private final String pub_date;
    private final String description;
    private final String category;
    private final String text;

    public NewsDTO(String news_id, String title, String link, String img, String pub_date, String description, String category, String text) {
        this.news_id = news_id;
        this.title = title;
        this.link = link;
        this.img = img;
        this.pub_date= pub_date;
        this.description = description;
        this.category = category;
        this.text = text;
    }

    public String getId(){
        return news_id;
    }

    public String getTitle(){
        return title;
    }

    public String getLink(){
        return link;
    }

    public String getImg(){
        return img;
    }

    public String getPubDate(){
        return pub_date;
    }

    public String getDescription(){
        return description;
    }

    public String getCategory(){
        return category;
    }

    public String getText(){
        return text;
    }
}
