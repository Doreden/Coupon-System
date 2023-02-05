package com.dor.couponsprojectapp.dto;

import com.dor.couponsprojectapp.enums.tables.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor

// CouponDTO is used to transfer data between the client and the server.
public class CouponDTO {

    private long id;
    public long companyId;
    public Category category;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;

}
