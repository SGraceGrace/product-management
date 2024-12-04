package com.project.product_management.entity;

import com.project.product_management.enums.Roles;
import com.project.product_management.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Column(name = "user_name", nullable = false)
    @NotNull(message = "Username cannot be null")
    private String userName;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "roles")
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuditLog> auditLogs;
}
