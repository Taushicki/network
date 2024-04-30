package org.example;

import org.example.client.ApiServices.ApiNewsServices;
import org.example.client.ApiServices.ApiUserServices;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiNewsServices api = new ApiNewsServices();
        ApiUserServices user_api = new ApiUserServices();

        try {
            System.out.println(user_api.getUserById("cf48fa60-d073-48b4-8d88-1320da68019f").getLogin());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}