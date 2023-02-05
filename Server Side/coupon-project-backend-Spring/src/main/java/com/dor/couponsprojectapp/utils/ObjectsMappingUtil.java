package com.dor.couponsprojectapp.utils;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.dto.CouponDTO;
import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.enums.tables.Role;
import com.dor.couponsprojectapp.model.Company;
import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

// This class is used to convert objects from one type to another.
public class ObjectsMappingUtil {

    //-----------------------------------------------------------------------------------------------------------------//
    // Objects Conversion Methods:
    //-----------------------------------------------------------------------------------------------------------------//

    // This method is used to convert a CompanyDTO object to a Company object.
    public static Company companyDtoToEntity(final CompanyDTO companyDto) {
        return Company.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .email(companyDto.getEmail())
                .password(companyDto.getPassword())
                .build();
    }

    // This method is used to convert a Company object to a CompanyDTO object.
    public static CompanyDTO companyEntityToDto(final Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .password(company.getPassword())

                .build();
    }

    // This method is used to convert a CustomerDTO object to a Customer object.
    public static Customer customerDtoToEntity(final CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .coupons(customerDTO.getCoupons())
                .build();
    }

    // This method is used to convert a Customer object to a CustomerDTO object.
    public static CustomerDTO customerEntityToDto(final Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .coupons(customer.getCoupons())
                .build();
    }

    // This method is used to convert a CouponDTO object to a Coupon object.
    public static Coupon couponDtoToEntity(final CouponDTO couponDTO) {
        return Coupon.builder()
                .id(couponDTO.getId())
                .companyId(couponDTO.getCompanyId())
                .category(couponDTO.getCategory())
                .title(couponDTO.getTitle())
                .description(couponDTO.getDescription())
                .startDate(couponDTO.getStartDate())
                .endDate(couponDTO.getEndDate())
                .amount(couponDTO.getAmount())
                .price(couponDTO.getPrice())
                .image(couponDTO.getImage())
                .build();
    }

    // This method is used to convert a Coupon object to a CouponDTO object.
    public static CouponDTO couponEntityToDto(final Coupon coupon) {
        return CouponDTO.builder()
                .id(coupon.getId())
                .companyId(coupon.getCompanyId())
                .category(coupon.getCategory())
                .title(coupon.getTitle())
                .description(coupon.getDescription())
                .startDate(coupon.getStartDate())
                .endDate(coupon.getEndDate())
                .amount(coupon.getAmount())
                .price(coupon.getPrice())
                .image(coupon.getImage())
                .build();
    }

    //----------------------------------------------------------------------------------------------------------------//
    // Objects LIST Conversion Methods:
    //---------------------------------------------------------------------------------------------------------------//

    // This method is used to convert a list of Company objects to a list of CompanyDTO objects.
    public static List<CompanyDTO> companyEntityListToDtoList(List<Company> companiesEntities) {
        return companiesEntities.stream()
                .map(ObjectsMappingUtil::companyEntityToDto)
                .collect(Collectors.toList());
    }

    // This method is used to convert a list of CompanyDTO objects to a list of Company objects.
    public static List<Company> companyDtoListToEntityList(List<CompanyDTO> companiesDTO) {
        return companiesDTO.stream()
                .map(ObjectsMappingUtil::companyDtoToEntity)
                .collect(Collectors.toList());
    }

    // This method is used to convert a list of Customer objects to a list of CustomerDTO objects.
    public static List<CustomerDTO> customerEntityListToDtoList(List<Customer> customersEntities) {
        return customersEntities.stream()
                .map(ObjectsMappingUtil::customerEntityToDto)
                .collect(Collectors.toList());
    }

    // This method is used to convert a list of CustomerDTO objects to a list of Customer objects.
    public static List<Customer> customerDtoListToEntityList(List<CustomerDTO> customersDTO) {
        return customersDTO.stream()
                .map(ObjectsMappingUtil::customerDtoToEntity)
                .collect(Collectors.toList());
    }

    // This method is used to convert a list of Coupon objects to a list of CouponDTO objects.
    public static List<CouponDTO> couponEntityListToDtoList(List<Coupon> couponsEntities) {
        return couponsEntities.stream()
                .map(ObjectsMappingUtil::couponEntityToDto)
                .collect(Collectors.toList());
    }

    // This method is used to convert a list of CouponDTO objects to a list of Coupon objects.
    public static List<Coupon> couponDtoListToEntityList(List<CouponDTO> couponsDTO) {
        return couponsDTO.stream()
                .map(ObjectsMappingUtil::couponDtoToEntity)
                .collect(Collectors.toList());
    }

    //----------------------------------------------------------------------------------------------------------------//
    // Mapping For Spring Security Objects:
    //----------------------------------------------------------------------------------------------------------------//
    // Company Entity To Spring Security:
    public static UserDetails companyToSpringSecurityUser(final Company company) {
        return new org.springframework.security.core.userdetails.User(
                company.getEmail(),
                company.getPassword(),
                new ArrayList<>()
        );
    }

    // Company Entity To Spring Security:
    public static UserDetails customerToSpringSecurityUser(final Customer customer) {
        return new org.springframework.security.core.userdetails.User(
                customer.getEmail(),
                customer.getPassword(),
                new ArrayList<>()
        );
    }

    // Admin To Spring Security:
    public static UserDetails adminToSpringSecurityUser(){
        return new org.springframework.security.core.userdetails.User(
                "admin@admin.com",
                "admin123",
                new ArrayList<>()

        );

    }
    //----------------------------------------------------------------------------------------------------------------//
}



