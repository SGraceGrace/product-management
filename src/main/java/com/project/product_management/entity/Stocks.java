package com.project.product_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "stocks")
public class Stocks extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_name")
    private String stockName;

    @Embedded
    private Quantity quantity;

    @ManyToMany(mappedBy = "stocks")
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "source_company_id", nullable = false)
    private SourceCompany sourceCompany;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;
}
