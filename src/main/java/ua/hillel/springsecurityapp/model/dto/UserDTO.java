package ua.hillel.springsecurityapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    @JsonIgnore
    private String password;
}
