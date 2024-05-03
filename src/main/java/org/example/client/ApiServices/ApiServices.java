package org.example.client.ApiServices;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.client.Delete;
import org.example.client.Get;
import org.example.client.Post;

public interface ApiServices {
    Get getRequest = new Get();
    Post postRequest = new Post();
    Delete deleteRequest = new Delete();
    Gson gson = new Gson();
}
