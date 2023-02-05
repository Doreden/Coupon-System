package com.dor.couponsprojectapp.enums.tables;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum Role {
    ADMIN("ADMIN"),
    COMPANY("COMPANY"),
    CUSTOMER("CUSTOMER");

    private final String role;
}
