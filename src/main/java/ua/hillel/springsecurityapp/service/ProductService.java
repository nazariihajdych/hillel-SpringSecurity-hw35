package ua.hillel.springsecurityapp.service;

import ua.hillel.springsecurityapp.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO removeProduct(ProductDTO productDTO);
}
