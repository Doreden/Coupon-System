package com.dor.couponsprojectapp.model;

import com.dor.couponsprojectapp.enums.tables.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coupons") // This is the name of the table in the DB.

// Coupon Data Class - This class is used to Define a Coupon in the DB.

public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_id")
    private Long companyId;

    @Enumerated(EnumType.STRING)
    @Column(name = "category" ,nullable = false)
    private Category category;

    @Column(name = "title" , nullable = false, unique = true)
    private String title;

    @Column(name = "description" ,nullable = false)
    private String description;

    @Column(name = "start_date" ,nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date" ,nullable = false)
    private LocalDate endDate;

    @Column(name = "amount" ,nullable = false)
    private int amount;

    @Column(name = "price" ,nullable = false)
    private double price;

    @Column(name = "image")
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "customer_to_coupons",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @ToString.Exclude
    private List<Customer> customers;
}
