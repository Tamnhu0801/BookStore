package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
