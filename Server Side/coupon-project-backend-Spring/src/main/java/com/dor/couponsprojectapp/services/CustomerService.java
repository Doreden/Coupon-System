package com.dor.couponsprojectapp.services;

import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.enums.tables.Category;
import com.dor.couponsprojectapp.enums.tables.Type;
import com.dor.couponsprojectapp.errors.Constraint;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.model.Customer;
import com.dor.couponsprojectapp.repositories.CouponRepository;
import com.dor.couponsprojectapp.repositories.CustomerRepository;
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
public class CustomerService {

    // Service Repositories:
    private final CustomerRepository customerRep;
    private final CouponRepository couponRep;

    //-----------------------------------------------------------------------------------------------------------------//
    // Customer Login Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public boolean login(final String email, final String password) {
        if (customerRep.existsByEmailAndPassword(email, password)) {
            log.info("Customer with email & password: " + email + " EXISTS in the DB!");
            return true;
        }
        try {
            throw new CouponAppException("Wrong email or password");
        } catch (CouponAppException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------------//
// Customer-To-Coupon Relevant Methods:
//-----------------------------------------------------------------------------------------------------------------//
// Customer Purchase Coupon Method:
    public void purchaseCoupon(final long customerID, final long couponID) throws  CouponAppException {

        Optional<Customer> customerOpt = customerRep.findById(customerID);
        Coupon coupon = couponRep.findById(couponID).get();

        if (customerOpt.isEmpty()) {
                throw new CouponAppException("This Customer does not exist!");
        }

        if (!couponRep.existsById(couponID)) {
                throw new CouponAppException("This Coupon does not exist!");
            }



        if (coupon.getAmount() <= 0) {
                throw new CouponAppException("This Coupon Is Out Of Stock!");
        }


        if (coupon.getEndDate().isBefore((LocalDate.now()))) {
                throw new CouponAppException("This Coupon Has Been Expired!");
            }



        if (customerRep.doesCouponExistsInCustomerCoupons(customerID, couponID) > 0) {
            throw new CouponAppException("You Already Purchased This Coupon!");
        }


        if (coupon.getAmount() > 0) {
            coupon.setAmount(coupon.getAmount() - 1);
        } else {
            throw new CouponAppException("This Coupon Is Out Of Stock!");
        }


        List<Coupon> customerOptcoupons = customerOpt.get().getCoupons();
        customerOptcoupons.add(coupon);
        customerOpt.get().setCoupons(customerOptcoupons);
        customerRep.save(customerOpt.get());
        log.info("Coupon: ID:" + coupon.getId() + " | " + coupon.getTitle() + " was purchased by successfully by customer with ID: " + customerID);
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Get All Available Coupons Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getAllCoupons() {
        // Checking if there are any coupons
        if (couponRep.findAll().isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any Coupons For This Customer!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        // Return the available coupons list
        return couponRep.findAll();
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get customer Coupons Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getCustomerCoupons(final long customerID) {
        Optional<Customer> customerOpt = customerRep.findById(customerID);
        if (customerOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Customer Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        if (customerOpt.get().getCoupons().isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any Coupons For This Customer!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        return customerOpt.get().getCoupons();
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get customer Coupons by Category Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getCustomerCouponsByCategory(final Long customerID, final Category category) {

        if (category == null) {
            try {
                throw new CouponAppException("Coupon Category Invalid!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        Optional<Customer> customerOpt = customerRep.findById(customerID);

        if (customerOpt.isEmpty()) {
            try {
                throw new CouponAppException("Customer Does Not Exist!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> customerOptCoupons = customerOpt.get().getCoupons();

        if (customerOptCoupons.isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any Coupons For This Customer!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> customerCouponsByCategory = customerOptCoupons.stream()
                .filter(coupon -> coupon.getCategory() == category)
                .collect(Collectors.toList());

        if (customerCouponsByCategory.isEmpty()) {
            try {
                throw new CouponAppException("Customer Doesn't Have any Coupons exists under this Category!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        log.info("Customer with ID: " + customerID + " has coupons of category: " + category);
        return customerCouponsByCategory;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Coupons by max price Method :
    //-----------------------------------------------------------------------------------------------------------------//
    public List<Coupon> getCustomerCouponsByPrice(final Long customerID, final double maxPrice) {
        if (maxPrice < 0) {
            try {
                throw new CouponAppException("Price Is Invalid");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        Optional<Customer> customerOpt = customerRep.findById(customerID);
        if (customerOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Customer does not exist");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> customerOptCoupons = customerOpt.get().getCoupons();

        if (customerOptCoupons.isEmpty()) {
            try {
                throw new CouponAppException("Customer Doesn't Have any Coupons! ");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        List<Coupon> customerCouponsByPrice = customerOptCoupons.stream()
                .filter(coupon -> coupon.getPrice() <= maxPrice)
                .collect(Collectors.toList());

        if (customerCouponsByPrice.isEmpty()) {
            try {
                throw new CouponAppException("Customer Doesn't Have any Coupons exists under this Price!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        log.info(Type.CUSTOMER + " with ID: " + customerID + ": Coupons which LOWER OR EQUAL to price: | " + maxPrice + " | " + " were retrieved successfully from the DB");
        return customerCouponsByPrice;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get Customer Details by ID:
    public CustomerDTO getCustomerDetails(long customerID) {

        Optional<Customer> customerOpt = customerRep.findById(customerID);

        if (customerOpt.isEmpty()) {
            try {
                throw new CouponAppException("Customer Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        CustomerDTO customerDTO = ObjectsMappingUtil.customerEntityToDto(customerOpt.get());
        log.info("Customer: ID:" + customerDTO.getId() + " | " + customerDTO.getFirstName() + ", " + customerDTO.getLastName() + " retrieved successfully from DB");
        return customerDTO;
    }
}
