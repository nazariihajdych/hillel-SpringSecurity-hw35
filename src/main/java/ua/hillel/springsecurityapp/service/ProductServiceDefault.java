package ua.hillel.springsecurityapp.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.hillel.springsecurityapp.model.dto.ProductDTO;
import ua.hillel.springsecurityapp.model.entity.Product;
import ua.hillel.springsecurityapp.model.mapper.ProductMapper;
import ua.hillel.springsecurityapp.repo.ProductRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceDefault implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepo.
                findById(id).
                orElseThrow(() -> new EntityNotFoundException("product with id:" + id + " is not found"));
        return productMapper.productToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::productToProductDTO).toList();
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        productRepo.save(product);
        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO removeProduct(ProductDTO productDTO) {
        productRepo.delete(productMapper.productDTOToProduct(productDTO));
        return productDTO;
    }
}
