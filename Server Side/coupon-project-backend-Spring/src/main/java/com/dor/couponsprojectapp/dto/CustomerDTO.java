package com.dor.couponsprojectapp.dto;

import com.dor.couponsprojectapp.enums.tables.Role;
import com.dor.couponsprojectapp.model.Coupon;
import lombok.*;

import java.util.List;

@Data
@ToString(exclude = "password")
@NoArgsConstructor
@Builder
@AllArgsConstructor

// CustomerDTO is used to transfer data between the client and the server.
public class CustomerDTO {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private List<Coupon> coupons;

}
