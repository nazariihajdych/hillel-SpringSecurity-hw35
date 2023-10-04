package ua.hillel.springsecurityapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "user")
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "user_password")
    private String password;
}
