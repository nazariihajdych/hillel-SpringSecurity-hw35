package ua.hillel.springsecurityapp.model.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String name;
    private String password;
}
