package com.dor.couponsprojectapp.model;

import com.dor.couponsprojectapp.enums.tables.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies") // This is the name of the table in the DB.

// Company Data Class - This class is used to Define a Company in the DB.
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name",nullable = false, unique = true)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "company_id")
    private List<Coupon> coupons;

}
