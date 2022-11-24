package com.hcmute.bookstore.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "int default 0")
    //0 - cho xac nhan
    //1 - cho lay hang
    //2 - dang giao
    //3 - giao thanh cong
    //4 - huy
    //5 - tra hang
    private int orderStatus;

    private String receiverName;

    private String phone;

    private String address;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_status", columnDefinition="boolean default false")
    private Boolean paymentStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
