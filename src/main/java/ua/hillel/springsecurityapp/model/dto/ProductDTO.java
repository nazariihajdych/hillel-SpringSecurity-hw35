package ua.hillel.springsecurityapp.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double cost;
}
