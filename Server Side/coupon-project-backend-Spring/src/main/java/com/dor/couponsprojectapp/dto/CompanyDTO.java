package com.dor.couponsprojectapp.dto;

import com.dor.couponsprojectapp.enums.tables.Role;
import lombok.*;

import java.util.List;

@Data
@ToString(exclude = "password")
@NoArgsConstructor
@Builder
@AllArgsConstructor

// CompanyDTO is used to transfer data between the client and the server.
public class CompanyDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<CouponDTO> coupons;
    private Role role;

}