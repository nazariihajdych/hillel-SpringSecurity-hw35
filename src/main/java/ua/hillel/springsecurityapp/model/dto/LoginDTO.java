package ua.hillel.springsecurityapp.model.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String name;
    private String password;
}
