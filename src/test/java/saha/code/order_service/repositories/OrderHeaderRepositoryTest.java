package saha.code.order_service.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import saha.code.order_service.domain.OrderHeader;
import saha.code.order_service.domain.OrderLine;
import saha.code.order_service.domain.Product;
import saha.code.order_service.domain.ProductStatus;

import java.math.BigInteger;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderRepositoryTest {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;
    @Autowired
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    void setUp() {
        Product newProduct = new Product();
        newProduct.setPrice(new BigInteger("1234",10));
        newProduct.setProductName("Test Product");
        newProduct.setProductStatus(ProductStatus.NEW);
        product = productRepository.saveAndFlush(newProduct);
    }

    @Test
    void testSaveOrderWithOrderLine(){
        OrderHeader newOrder = new OrderHeader("Test order");
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setProduct(product);

        newOrder.addOrderLine(orderLine);
        OrderHeader order = orderHeaderRepository.save(newOrder);
        assertThat(order).isNotNull();
        assertThat(order.getId()).isNotNull();
        assertThat(order.getOrderLines()).isNotNull();
        assertEquals(order.getOrderLines().size(), 1);

        OrderHeader fetchedOrder = orderHeaderRepository.getById(order.getId());
        assertNotNull(fetchedOrder);
        assertEquals(fetchedOrder.getOrderLines().size(),1);
    }

    @Test
    void testSaveOrder(){
        OrderHeader newOrder = new OrderHeader("Test order");
        OrderHeader order = orderHeaderRepository.save(newOrder);
        assertThat(order).isNotNull();
        assertThat(order.getId()).isNotNull();
        OrderHeader savedOrder = orderHeaderRepository.getById(order.getId());
        System.out.printf("ID: %d", savedOrder.getId());
        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getCreatedDate()).isNotNull();

    }
}
