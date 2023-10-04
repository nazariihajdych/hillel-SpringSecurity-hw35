package ua.hillel.springsecurityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.hillel.springsecurityapp.exception.EntityNotFoundException;
import ua.hillel.springsecurityapp.model.dto.ProductDTO;
import ua.hillel.springsecurityapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeProduct(@RequestBody ProductDTO productDTO){
        productService.removeProduct(productDTO);
    }
}

