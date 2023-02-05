package com.dor.couponsprojectapp.services;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.enums.tables.Role;
import com.dor.couponsprojectapp.enums.tables.Type;
import com.dor.couponsprojectapp.errors.Constraint;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Admin;
import com.dor.couponsprojectapp.model.Company;
import com.dor.couponsprojectapp.model.Customer;
import com.dor.couponsprojectapp.repositories.AdminRepository;
import com.dor.couponsprojectapp.repositories.CompanyRepository;
import com.dor.couponsprojectapp.repositories.CustomerRepository;
import com.dor.couponsprojectapp.utils.ObjectsMappingUtil;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Builder
public class AdminService {

    private static final String ADMIN_EMAIL = "admin@admin.com";
    private static final String ADMIN_PASSWORD = "admin";

    // Service Repositories:
    private final CompanyRepository companyRep;
    private final CustomerRepository customerRep;
    private final AdminRepository adminRepository;

    // Service Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Admin Login Method:
    //-----------------------------------------------------------------------------------------------------------------//
    public boolean login(final String email, final String password) {
        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            log.info(Type.ADMIN + " Credentials Has Been Entered!");
            return true;
        }
        try {
            throw new CouponAppException("Wrong credentials!");
        } catch (CouponAppException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Admin-To-Company Relevant Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    public void createAdmin() {
        Admin admin = Admin.builder()
                .email(ADMIN_EMAIL)
                .password(ADMIN_PASSWORD)
                .role(Role.ADMIN)
                .build();
        adminRepository.save(admin);
        System.out.println("Admin Successfully Created!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Admin-To-Company Relevant Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Create new company - save it in the DB Method:
    public CompanyDTO createCompany(final CompanyDTO companyDTO) {

        if (companyRep.existsByName(companyDTO.getName())) {
            try {
                throw new CouponAppException("Company Name Already Exists!");
            } catch (CouponAppException e) {
                throw new RuntimeException(e);
            }
        }

        final Company companyToAdd = ObjectsMappingUtil.companyDtoToEntity(companyDTO);
        final Company companyAfter = companyRep.save(companyToAdd);
        log.info("A New Company :" + companyAfter.getName() + " was created successfully.");
        return ObjectsMappingUtil.companyEntityToDto(companyAfter);

    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Update a company details from the DB:
    public CompanyDTO updateCompany(final CompanyDTO companyDTO) throws CouponAppException {
        Optional<Company> optCompany = companyRep.findById(companyDTO.getId());

        if (companyDTO.getId() == null) {
            try {
                throw new CouponAppException("This Company Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        if (!companyDTO.getName().equals(optCompany.get().getName())){
                throw new CouponAppException("Cant Change Company Name!");
            }


        final Company companyToUpdate = ObjectsMappingUtil.companyDtoToEntity(companyDTO);
        final Company companyAfter = companyRep.save(companyToUpdate);
        log.info("Company :" + "with ID:" + companyAfter.getId() + "||" + companyAfter.getName() + " was updated successfully.");
        return ObjectsMappingUtil.companyEntityToDto(companyAfter);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Delete a company from the DB:
    public void deleteCompany(final long companyId) {
        if (companyRep.existsById(companyId)) {
            companyRep.deleteById(companyId);
            log.info("Company with id: " + companyId + " was Successfully deleted from the DB.");
        } else {
            try {
                throw new CouponAppException("This Company Does Not Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//

    // Get all companies from the DB:
    public List<Company> getAllCompanies() {
        List<Company> companyList = companyRep.findAll();
        if (companyList.isEmpty()) {
            try {
                throw new CouponAppException("There Arent Any Companies In DB!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        log.info("All companies were successfully retrieved from the DB.");
        return companyList;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get a company from the DB:
    public CompanyDTO getOneCompany(final long companyID) {
        Optional<Company> companyOpt = companyRep.findById(companyID);
        if (companyOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Company Does Not Exist!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        CompanyDTO companyDTO = ObjectsMappingUtil.companyEntityToDto(companyOpt.get());
        log.info("Company: " + companyDTO.getName() + "with id: " + companyID + " was Successfully returned from the DB");
        return companyDTO;
    }

    //-----------------------------------------------------------------------------------------------------------------//


    // Admin-To-Customer Relevant Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    // Create new customer - save it in the DB Method:
    public CustomerDTO createCustomer(final CustomerDTO customerDTO) {
        if (customerRep.existsByEmail(customerDTO.getEmail())) {
            try {
                throw new CouponAppException("Customer email Already Exists!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        final Customer customerToAdd = ObjectsMappingUtil.customerDtoToEntity(customerDTO);
        final Customer customerAfter = customerRep.save(customerToAdd);
        log.info("A New Customer :" + customerAfter.getFirstName() + " " + customerAfter.getLastName() + " was created successfully.");
        return ObjectsMappingUtil.customerEntityToDto(customerAfter);
    }
    //-----------------------------------------------------------------------------------------------------------------//
    // Update a customer details from the DB:

    public CustomerDTO updateCustomer(final CustomerDTO customerDTO) {

        if (customerDTO.getId() == null) {
            try {
                throw new CouponAppException("Customer Not Found!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }

        final Customer customerToUpdate = ObjectsMappingUtil.customerDtoToEntity(customerDTO);
        final Customer customerAfter = customerRep.save(customerToUpdate);
        log.info("Customer: " + customerAfter.getId() + "||" + customerAfter.getFirstName() + "," + customerAfter.getLastName() + " was Successfully updated in the DB.");
        return ObjectsMappingUtil.customerEntityToDto(customerAfter);
    }


    //-----------------------------------------------------------------------------------------------------------------//
    // Delete a customer from the DB:
    public void deleteCustomer(final long customerID) {
        if (customerRep.existsById(customerID)) {
            customerRep.deleteById(customerID);
            log.info("Customer with id: " + customerID + " was Successfully deleted from the DB.");
        } else {
            try {
                throw new CouponAppException("Customer Has Not Found Or Been Deleted Already!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get all customers from the DB:
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRep.findAll();
        if (customerList.isEmpty()) {
            try {
                throw new CouponAppException("There Arent Customers In The DB");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        log.info("All customers were successfully retrieved from the DB.");
        return customerList;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Get customer by id from the DB:
    public CustomerDTO getOneCustomer(long customerID) {

        Optional<Customer> customerOpt = customerRep.findById(customerID);
        if (customerOpt.isEmpty()) {
            try {
                throw new CouponAppException("This Customer Does Not Exist In The DB!");
            } catch (CouponAppException e) {
                log.error(e.getMessage());
            }
        }
        CustomerDTO customerDTO = ObjectsMappingUtil.customerEntityToDto(customerOpt.get());
        log.info("Customer: " + customerDTO.getFirstName() + " " + customerDTO.getLastName() + "with id: " + customerID + " was Successfully returned from the DB");
        return customerDTO;

    }
    //-----------------------------------------------------------------------------------------------------------------//


}
