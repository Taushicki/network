package org.example.client.dto;

public class UserDTO {
    private final String user_id;
    private final String login;
    private final String email;
    private final String rights;

    public UserDTO(String user_id, String login, String email, String password, String rights ){
        this.user_id = user_id;
        this.login = login;
        this.email = email;
        this.rights = rights;
    }

    public String getId(){ return user_id; }

    public String getLogin() { return login; }

    public String getEmail() { return email; }

    public String getRights() { return rights; }
}
