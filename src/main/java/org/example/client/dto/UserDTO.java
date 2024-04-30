package org.example.client.dto;

public class UserDTO {
    private final String user_id;
    private final String login;
    private final String email;
    private final String password;
    private final String rights;

    public UserDTO(String user_id, String login, String email, String password, String rights ){
        this.user_id = user_id;
        this.login = login;
        this.email = email;
        this. password = password;
        this.rights = rights;
    }
}
