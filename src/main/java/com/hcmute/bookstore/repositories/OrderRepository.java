package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT SUM(o.total) total\n" +
            "FROM orders o\n" +
            "WHERE Year(o.order_time) = :year\n" +
            "AND Month(o.order_time) = :month", nativeQuery = true)
    BigDecimal findRevenueOfMonth(@Param(value = "month") String month, @Param(value = "year") String year);

    @Query(value = "SELECT SUM(o.total) total\n" +
            "FROM orders o\n" +
            "WHERE Year(o.order_time) = :year\n" +
            "AND Month(o.order_time) = :month" +
            "AND Day(o.order_time) = :day", nativeQuery = true)
    BigDecimal findRevenueOfDay(@Param(value = "month") String month, @Param(value = "year") String year);

    @Query(value = "SELECT SUM(o.total) total\n" +
            "FROM orders o", nativeQuery = true )
    BigDecimal findTotalRevenue();

}
