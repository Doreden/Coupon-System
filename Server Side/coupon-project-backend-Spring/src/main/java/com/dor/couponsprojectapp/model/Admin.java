package com.dor.couponsprojectapp.model;

import com.dor.couponsprojectapp.enums.tables.Role;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin")
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private Role role;
}
