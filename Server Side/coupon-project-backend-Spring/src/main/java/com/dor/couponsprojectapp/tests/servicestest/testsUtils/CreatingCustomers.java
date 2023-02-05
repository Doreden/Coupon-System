package com.dor.couponsprojectapp.tests.servicestest.testsUtils;

import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.enums.mocks.CustomersMocks;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreatingCustomers {

    public static CustomerDTO dorCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.DOR.getFirstName())
                .lastName(CustomersMocks.DOR.getLastName())
                .email(CustomersMocks.DOR.getEmail())
                .password(CustomersMocks.DOR.getPassword())
                .build();
    }

    public static CustomerDTO idanCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.IDAN.getFirstName())
                .lastName(CustomersMocks.IDAN.getLastName())
                .email(CustomersMocks.IDAN.getEmail())
                .password(CustomersMocks.IDAN.getPassword())
                .build();
    }

    public static CustomerDTO orCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.OR.getFirstName())
                .lastName(CustomersMocks.OR.getLastName())
                .email(CustomersMocks.OR.getEmail())
                .password(CustomersMocks.OR.getPassword())
                .build();
    }

    public static CustomerDTO danielCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.DANIEL.getFirstName())
                .lastName(CustomersMocks.DANIEL.getLastName())
                .email(CustomersMocks.DANIEL.getEmail())
                .password(CustomersMocks.DANIEL.getPassword())
                .build();
    }

    public static CustomerDTO omerCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.OMER.getFirstName())
                .lastName(CustomersMocks.OMER.getLastName())
                .email(CustomersMocks.OMER.getEmail())
                .password(CustomersMocks.OMER.getPassword())
                .build();
    }

    public static CustomerDTO davidCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.DAVID.getFirstName())
                .lastName(CustomersMocks.DAVID.getLastName())
                .email(CustomersMocks.DAVID.getEmail())
                .password(CustomersMocks.DAVID.getPassword())
                .build();
    }

    public static CustomerDTO meitalCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.MEITAL.getFirstName())
                .lastName(CustomersMocks.MEITAL.getLastName())
                .email(CustomersMocks.MEITAL.getEmail())
                .password(CustomersMocks.MEITAL.getPassword())
                .build();
    }

    public static CustomerDTO emilCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.EMIL.getFirstName())
                .lastName(CustomersMocks.EMIL.getLastName())
                .email(CustomersMocks.EMIL.getEmail())
                .password(CustomersMocks.EMIL.getPassword())
                .build();
    }

    public static CustomerDTO nitayCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.NITAY.getFirstName())
                .lastName(CustomersMocks.NITAY.getLastName())
                .email(CustomersMocks.NITAY.getEmail())
                .password(CustomersMocks.NITAY.getPassword())
                .build();
    }

    public static CustomerDTO liorCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.LIOR.getFirstName())
                .lastName(CustomersMocks.LIOR.getLastName())
                .email(CustomersMocks.LIOR.getEmail())
                .password(CustomersMocks.LIOR.getPassword())
                .build();
    }

    public static CustomerDTO tanyaCreateCustomer() {
        return CustomerDTO.builder()
                .firstName(CustomersMocks.TANYA.getFirstName())
                .lastName(CustomersMocks.TANYA.getLastName())
                .email(CustomersMocks.TANYA.getEmail())
                .password(CustomersMocks.TANYA.getPassword())
                .build();
    }

}
