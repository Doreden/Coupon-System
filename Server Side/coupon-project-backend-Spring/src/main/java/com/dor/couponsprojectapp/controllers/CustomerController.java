package com.dor.couponsprojectapp.controllers;

import com.dor.couponsprojectapp.dto.CouponDTO;
import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.dto.ResponseDTO;
import com.dor.couponsprojectapp.enums.tables.Category;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@CrossOrigin

public class CustomerController {

    // Class Services
    private final CustomerService customerService;

    //-----------------------------------------------------------------------------------------------------------------//
    // Customer-to-Coupon - Web Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Post - Create Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/{couponId}")
    public ResponseDTO customerPurchaseCouponWeb(@PathVariable final long id , @PathVariable final long couponId) throws CouponAppException {
        customerService.purchaseCoupon(id,couponId);
        return new ResponseDTO(true, " Purchased successfully Coupon  Mazal Tov!");
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Get All - Get All Available Coupons Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Coupon> getAllCouponsWeb(){
        return customerService.getAllCoupons();
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Get All - Get All Customer Owned Coupon Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public List<Coupon> getAllCustomerCouponsWeb(@PathVariable final long id) throws CouponAppException {
        return customerService.getCustomerCoupons(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Customer Coupons By:
    // 1. CustomerID
    // 2. Given Maximum Price Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/coupons/{id}/{maxPrice}")
    public List<Coupon> getCustomerCouponsByMaxPriceWeb(@PathVariable final long id,@PathVariable final double maxPrice) throws CouponAppException {
        return customerService.getCustomerCouponsByPrice(id,maxPrice);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Customer Coupons By:
    // 1. CustomerID
    // 2. Given Coupon Category Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/coupons/{id}/{category}")
    public List<Coupon> getCustomerCouponsByCategoryWeb(@PathVariable final long id,@PathVariable final String category) throws CouponAppException {
        return customerService.getCustomerCouponsByCategory(id, Category.valueOf(category));
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Customer Details By Customer ID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/details/{id}")
    public CustomerDTO getCustomerDetailsWeb(@PathVariable final long id) throws CouponAppException {
        return customerService.getCustomerDetails(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//




}
