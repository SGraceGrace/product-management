package com.project.product_management.entity;

import com.project.product_management.enums.Action;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "audit_log")
public class AuditLog extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action")
    @Enumerated(value = EnumType.STRING)
    private Action action;

    @Column(name = "entity")
    @Enumerated(value = EnumType.STRING)
    private Entity entity;

    @Column(name = "entity_id")
    private Long entityId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
