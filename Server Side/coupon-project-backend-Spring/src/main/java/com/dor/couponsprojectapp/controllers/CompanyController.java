package com.dor.couponsprojectapp.controllers;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.dto.CouponDTO;
import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.dto.ResponseDTO;
import com.dor.couponsprojectapp.enums.tables.Category;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("company")
@RestController
@RequiredArgsConstructor
@CrossOrigin

public class CompanyController {

    // Class Services
    private final CompanyService companyService;

    //-----------------------------------------------------------------------------------------------------------------//
    // Company-to-Coupon - Web Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    //Post - Company Creating a Coupon Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseDTO createCompanyCouponWeb(@RequestBody final CouponDTO couponDTO) throws CouponAppException {
        System.out.println(couponDTO.toString());
        companyService.createCompanyCoupon(couponDTO);
        return new ResponseDTO(true, "Successfully Created Coupon With ID: " + couponDTO.getId() + " Good Luck!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Delete - Delete Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public ResponseDTO deleteCompanyCouponWeb(@PathVariable final long id) throws CouponAppException {
        companyService.deleteCoupon(id);
        return new ResponseDTO(true,"Company Successfully Deleted Coupon With ID: " + id + " Were Sorry For Your Loss ): ");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Put - Update a Given Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @PutMapping()
    public ResponseDTO updateCompanyCouponWeb(@RequestBody final CouponDTO couponDTO) throws CouponAppException {
        companyService.updateCompanyCoupon(couponDTO);
        return new ResponseDTO(true, "Successfully Updated Coupon With ID: " + couponDTO.getId() + " Good Job!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Get All - Get All Company Coupons By given Company ID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/coupons/{id}")
    public List<Coupon> getAllCompanyCouponsWeb(@PathVariable final long id) throws CouponAppException {
        return companyService.getAllCouponsByID(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Get - Get One Company Coupon By CouponID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CouponDTO getOneCompanyCouponWeb(@PathVariable final long id) throws CouponAppException {
        return companyService.getOneCoupon(id);
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Coupons By:
    // 1. CompanyID
    // 2. Given Maximum Price Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/coupons/{id}/{maxPrice}")
    public List<Coupon> getCompanyCouponsByMaxPriceWeb(@PathVariable final long id , @PathVariable final double maxPrice) throws CouponAppException {
        return companyService.getCompanyCouponsByPrice(id,maxPrice);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Coupons By:
    // 1. CompanyID
    // 2. Given Coupon Category Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/coupons/{id}/{category}")
    public List<Coupon> getCompanyCouponsByCategoryWeb(@PathVariable final long id , @PathVariable final String category ) throws CouponAppException {
        return companyService.getCompanyCouponsByCategory(id, Category.valueOf(category));
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Details By CompanyID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/details/{id}")
    public CompanyDTO getCompanyDetailsWeb(@PathVariable("id") final long id) throws CouponAppException {
        return companyService.getCompanyDetails(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//

}
