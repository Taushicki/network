package org.example;

import org.example.client.ApiServices.ApiNewsServices;
import org.example.client.ApiServices.ApiUserServices;
import org.example.client.dto.UserDTO;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiNewsServices api = new ApiNewsServices();
        ApiUserServices user_api = new ApiUserServices();

        try {
            for (UserDTO user : user_api.getAllUsers()){
                System.out.println(user.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}