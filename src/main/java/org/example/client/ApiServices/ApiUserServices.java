package org.example.client.ApiServices;

public class ApiUserServices implements ApiServices {

    public String getUserById(String user_id){
        try{
            return getRequest.get("/users/get_by_id/%s".formatted(user_id));
        } catch (Exception error){
            error.printStackTrace();
            return "Error";
        }
    }
    public String getAllUsers(){
        try{
            return getRequest.get("/users/get_all");
        } catch (Exception error){
            error.printStackTrace();
            return "Error";

        }
    }
}
