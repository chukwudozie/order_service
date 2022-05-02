package saha.code.order_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saha.code.order_service.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String productName);
}
