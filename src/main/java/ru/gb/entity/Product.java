package ru.gb.entity;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;
    private LocalDate date;
}
