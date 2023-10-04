package ua.hillel.springsecurityapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "product")
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
}
