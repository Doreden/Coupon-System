package com.dor.couponsprojectapp.services;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.dto.CouponDTO;
import com.dor.couponsprojectapp.enums.tables.Category;
import com.dor.couponsprojectapp.enums.tables.Type;
import com.dor.couponsprojectapp.errors.Constraint;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Company;
import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.repositories.CompanyRepository;
import com.dor.couponsprojectapp.repositories.CouponRepository;
import com.dor.couponsprojectapp.utils.ObjectsMappingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    // Service Repositories:
    private final CompanyRepository companyRep;
    private final CouponRepository couponRep;

    //-----------------------------------------------------------------------------------------------------------------//
    // Service Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Company Login Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public boolean login(final String email, final String password) {
        if (companyRep.existsByEmailAndPassword(email, password)) {
            log.info("Company with email & password: " + email + " EXISTS in the DB!");
            return true;
        }
        try {
            throw new CouponAppException("Wrong email or password!");
        } catch (CouponAppException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Company-To-Coupon Relevant Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Create new coupon - save it in the DB Method:
    public void createCompanyCoupon(final CouponDTO couponDTO) throws CouponAppException {
        if (couponRep.existsByTitle(couponDTO.getTitle())) {
                throw new CouponAppException("This Coupon Title is already exists!");

        }

        if (couponDTO.getEndDate().isBefore(couponDTO.getStartDate())) {
                throw new CouponAppException("End Date cannot Proceed Start Date!");
            }


        Optional<Company> companyOpt = companyRep.findById(couponDTO.getCompanyId());
        if (companyOpt.isPresent()) {
            final Coupon couponToAdd = ObjectsMappingUtil.couponDtoToEntity(couponDTO);
            companyOpt.get().getCoupons().add(couponToAdd);
            final Coupon couponAfter = couponRep.save(couponToAdd);
            log.info("A New Coupon :" + couponAfter.getTitle() + " was created successfully.");
        } else {
            try {
                throw new CouponAppException("This Company Does not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Update a coupon details from the DB:
    //-----------------------------------------------------------------------------------------------------------------//
    public CouponDTO updateCompanyCoupon(final CouponDTO couponDTO) throws CouponAppException {

        if (couponDTO.getId() <= 0) {
            try {
                throw new CouponAppException("This Coupon Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }



        if (couponDTO.getEndDate().isBefore(couponDTO.getStartDate())) {
                throw new CouponAppException("End Date cannot Proceed Start Date!");
        }

        if (couponDTO.getEndDate().isBefore(LocalDate.now())) {
            throw new CouponAppException("End Date cannot Proceed Current Date!");
        }

        Optional<Company> companyOpt = companyRep.findById(couponDTO.getCompanyId());

        if (companyOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Company Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        final Coupon couponToUpdate = ObjectsMappingUtil.couponDtoToEntity(couponDTO);
        companyOpt.get().getCoupons().add(couponToUpdate);
        final Coupon couponAfter = couponRep.save(couponToUpdate);
        log.info("Coupon :" + "with ID: " + couponAfter.getId() + "||" + couponAfter.getTitle() + " was updated successfully.");
        return ObjectsMappingUtil.couponEntityToDto(couponAfter);
    }
    //-----------------------------------------------------------------------------------------------------------------//
    // Delete a coupon from the DB:
    //-----------------------------------------------------------------------------------------------------------------//

    public void deleteCoupon(final long couponId) {
        if (couponRep.existsById(couponId)) {
            couponRep.deleteById(couponId);
            log.info("Coupon with ID: " + couponId + " was deleted successfully.");
        } else {
            try {
                throw new CouponAppException("This Coupon Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get all coupons from the DB:
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getAllCouponsByID(final long companyID) {
        List<Coupon> couponsList = couponRep.findCouponByCompanyId(companyID);
        if (couponsList.isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any coupons for this company!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        log.info("All coupons were retrieved successfully.");
        return couponsList;

    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get a coupon from the DB:
    //-----------------------------------------------------------------------------------------------------------------//
    public CouponDTO getOneCoupon(final long couponID) {
        Optional<Coupon> couponOpt = couponRep.findById(couponID);
        if (couponOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Coupon Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }

        }
        CouponDTO couponDTO = ObjectsMappingUtil.couponEntityToDto(couponOpt.get());
        log.info("Coupon with ID: " + couponID + " was returned successfully.");
        return couponDTO;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Coupons by max price Method :
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getCompanyCouponsByPrice(final Long companyID, final double maxPrice) {
        if (maxPrice < 0) {
            try {
                throw new CouponAppException("Invalid Price!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        Optional<Company> companyOpt = companyRep.findById(companyID);
        if (companyOpt.isEmpty()) {
            try {
                throw new CouponAppException("Company Does Not Exist!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> companyOptCoupons = companyOpt.get().getCoupons();

        if (companyOptCoupons.isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any coupons for this company!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> companyCouponsByPrice = companyOptCoupons.stream()
                .filter(coupon -> coupon.getPrice() <= maxPrice)
                .collect(Collectors.toList());

        if (companyCouponsByPrice.isEmpty()) {
            try {
                throw new CouponAppException("Company Doesn't Have any Coupons exists under this Price!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        log.info(Type.COMPANY + " with ID: " + companyID + ": Coupons which LOWER OR EQUAL to price: | " + maxPrice + " | " + " were retrieved successfully from the DB");
        return companyCouponsByPrice;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Coupons by Category Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getCompanyCouponsByCategory(final Long companyID, final Category category) {

        if (category == null) {
            try {
                throw new CouponAppException("Invalid Category!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        Optional<Company> companyOpt = companyRep.findById(companyID);

        if (companyOpt.isEmpty()) {
            try {
                throw new CouponAppException("Company Does Not Exist!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> companyOptCoupons = companyOpt.get().getCoupons();

        if (companyOptCoupons.isEmpty()) {
            try {
                throw new CouponAppException("This Company Doesn't Have Any Coupons!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> companyCouponsByCategory = companyOptCoupons.stream()
                .filter(coupon -> coupon.getCategory() == category)
                .collect(Collectors.toList());

        if (companyCouponsByCategory.isEmpty()) {
            try {
                throw new CouponAppException("Company Doesn't Have any Coupons exists under this Category!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        log.info(Type.COMPANY + " with ID: " + companyID + " has coupons of category: " + category);
        return companyCouponsByCategory;
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Get Company Details:
    //-----------------------------------------------------------------------------------------------------------------//
    public CompanyDTO getCompanyDetails(final long companyID) {
        Optional<Company> companyOpt = companyRep.findById(companyID);
        if (companyOpt.isEmpty()) {
            try {
                throw new CouponAppException("This company Doesn't exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        CompanyDTO companyDTO = ObjectsMappingUtil.companyEntityToDto(companyOpt.get());
        log.info("Company with ID: " + companyID + " was returned successfully.");
        return companyDTO;
    }

}



