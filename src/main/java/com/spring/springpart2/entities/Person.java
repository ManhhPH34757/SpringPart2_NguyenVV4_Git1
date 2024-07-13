package com.spring.springpart2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "person_first_name", length = 50)
    private String personFirstName;

    @Size(max = 50)
    @Nationalized
    @Column(name = "person_last_name", length = 50)
    private String personLastName;

    @Size(max = 10)
    @Nationalized
    @Column(name = "person_gender", length = 10)
    private String personGender;

    @Size(max = 100)
    @Nationalized
    @Column(name = "person_email", length = 100)
    private String personEmail;

    @Size(max = 20)
    @Nationalized
    @Column(name = "person_phone_number", length = 20)
    private String personPhoneNumber;

    @Nationalized
    @Lob
    @Column(name = "person_address")
    private String personAddress;

    @Size(max = 50)
    @Nationalized
    @Column(name = "person_role", length = 50)
    private String personRole;

}