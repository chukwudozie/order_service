package saha.code.order_service.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

    @Test
    void testEqualsForOrderHeader() {
        OrderHeader order1 = new OrderHeader();
        OrderHeader order2 = new OrderHeader();
        order1.setId(1L);
        order2.setId(1L);

        assert order1.equals(order2);
    }

    @Test
    void testNotEqualsForOrderHeader() {
        OrderHeader order1 = new OrderHeader();
        OrderHeader order2 = new OrderHeader();
        order1.setId(1L);
        order2.setId(3L);

        assertNotEquals(order1, order2);
    }
}