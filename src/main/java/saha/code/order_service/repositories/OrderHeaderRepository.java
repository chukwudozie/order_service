package saha.code.order_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saha.code.order_service.domain.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
}
