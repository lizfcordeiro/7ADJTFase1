package com.ADJT.fase1.demo.entity.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    protected Date createAt;
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @PreUpdate
    @PrePersist
    private void prePersist() {
        updatedAt = LocalDateTime.now();
    }
}