package saha.code.order_service.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import saha.code.order_service.domain.Product;
import saha.code.order_service.domain.ProductStatus;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCategory(){
        Product product = productRepository.findByProductName("PRODUCT1");
        product.getCategories().forEach(category -> {
            System.out.println(category.getDescription());
        });
        assertNotNull(product);
        assertNotNull(product.getCategories());
    }   

    @Test
    void testProduct() {
        Product product = new Product();
        product.setProductName("Pizza");
        product.setProductStatus(ProductStatus.NEW);
        product.setPrice(new BigInteger("23400"));
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getCreatedDate());

        Product fetchedProduct = productRepository.getById(savedProduct.getId());
        assertNotNull(fetchedProduct);
        assertNotNull(fetchedProduct.getCreatedDate());
    }
}