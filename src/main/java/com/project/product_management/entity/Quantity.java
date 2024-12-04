package com.project.product_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Quantity {

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "units")
    private String units;
}
