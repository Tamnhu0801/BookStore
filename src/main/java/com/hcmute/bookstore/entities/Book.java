package com.hcmute.bookstore.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 4096)
    private String description;

    @Column(name = "publish_date")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "publishing_house")
    private String publishingHouse;

    private String translator;

    @Column(name = "number_of_pages")
    private long numberOfPages;

    @Column(columnDefinition="int default 0")
    private int quantity;

    private BigDecimal price;

    @Column(name = "cover_price")
    private BigDecimal coverPrice;

    @Column(columnDefinition = "boolean default true")
    private boolean status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
