package ua.hillel.springsecurityapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hillel.springsecurityapp.model.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
