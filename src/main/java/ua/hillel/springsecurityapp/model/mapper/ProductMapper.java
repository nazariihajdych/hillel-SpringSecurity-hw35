package ua.hillel.springsecurityapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.hillel.springsecurityapp.model.dto.ProductDTO;
import ua.hillel.springsecurityapp.model.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {

    public abstract ProductDTO productToProductDTO(Product product);
    public abstract Product productDTOToProduct(ProductDTO productDTO);

}
