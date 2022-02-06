package ru.gb.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "PRODUCT")
@NamedQueries({

        @NamedQuery(name = "Product.findNameById",
                query = "select p.title from Product p where p.id = :id"),

        @NamedQuery(name = "Product.findById",
                query = "select p from Product p where p.id = :id")
})


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "manufacture_date")
    private LocalDate date;
    @Column(name = "manufacturer_id")
    private Long manufacturerId;
    @Transient
    private String manufacturer;
}
