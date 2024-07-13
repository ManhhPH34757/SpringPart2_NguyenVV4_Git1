package com.spring.springpart2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Size(max = 50)
    @Nationalized
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password_hash")
    private byte[] passwordHash;

    @Size(max = 10)
    @Nationalized
    @Column(name = "account_status", length = 10)
    private String accountStatus;

}