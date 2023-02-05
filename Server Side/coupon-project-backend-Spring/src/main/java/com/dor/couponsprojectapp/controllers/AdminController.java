package com.dor.couponsprojectapp.controllers;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.dto.CustomerDTO;
import com.dor.couponsprojectapp.dto.ResponseDTO;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Company;
import com.dor.couponsprojectapp.model.Customer;
import com.dor.couponsprojectapp.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@CrossOrigin
@Controller
@RestController
@RequiredArgsConstructor
public class AdminController {

    // Class Services
    private final AdminService adminService;

    //-----------------------------------------------------------------------------------------------------------------//
    // Admin-to-Company - Web Methods:
    //-----------------------------------------------------------------------------------------------------------------//
    //Post - Create Company Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/company/")
    public ResponseDTO createCompanyWeb(@RequestBody final CompanyDTO companyDTO) throws CouponAppException {
        adminService.createCompany(companyDTO);
        return new ResponseDTO(true,"A New Company With The Name: " + companyDTO.getName() + " Created Successfully | Mazal Tov!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Delete - Delete Company Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/company/{id}")
    public ResponseDTO deleteCompanyWeb(@PathVariable final long id) throws CouponAppException {
        adminService.deleteCompany(id);
        return new ResponseDTO(true,"Company With ID: " + id +  "Deleted successfully | Were Sorry For Your Loss ): ");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Put - Update a Given Company Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/company")
    public ResponseDTO updateCompanyWeb(@RequestBody final CompanyDTO companyDTO) throws CouponAppException {
        adminService.updateCompany(companyDTO);
        return new ResponseDTO(true,"Company With ID: " + companyDTO.getId() +  " Updated successfully | Good Job!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //GetAll - Get All Companies Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/companies")
    public List<Company> getAllCompaniesWeb() throws CouponAppException {
        return adminService.getAllCompanies();
    }


    //-----------------------------------------------------------------------------------------------------------------//
    //Get - Get One Company By CompanyID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/company/{id}")
    public CompanyDTO getOneCompanyWeb(@PathVariable final long id) throws CouponAppException {
        return adminService.getOneCompany(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    // Admin-to-Customer - Web Services:
    //-----------------------------------------------------------------------------------------------------------------//
    //Post - Create Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customer")
    public ResponseDTO createCustomerWeb(@RequestBody final CustomerDTO customerDTO) throws CouponAppException {
        adminService.createCustomer(customerDTO);
        return new ResponseDTO(true,"A New Customer With The Name: " + customerDTO.getFirstName() + ", " + customerDTO.getLastName() + " Created successfully | Mazal Tov!");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Delete - Delete Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/customer/{id}")
    public ResponseDTO deleteCustomerWeb(@PathVariable final long id) throws CouponAppException {
        adminService.deleteCustomer(id);
        return new ResponseDTO(true,"Customer With ID: " + id + "Deleted successfully");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Put - Update a Given Customer Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/customer")
    public ResponseDTO updateCustomerWeb(@RequestBody final CustomerDTO customerDTO) throws CouponAppException {
        adminService.updateCustomer(customerDTO);
        return new ResponseDTO(true,"Customer With ID: " + customerDTO.getId() +  "Updated successfully");
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //GetAll - Get All Customers Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customers")
    public List<Customer> getAllCustomersWeb() throws CouponAppException {
        return adminService.getAllCustomers();
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Get - Get One Customer By CustomerID Web JSON:
    //-----------------------------------------------------------------------------------------------------------------//
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customer/{id}")
    public CustomerDTO getOneCustomerWeb(@PathVariable final long id) throws CouponAppException {
        return adminService.getOneCustomer(id);
    }

    //-----------------------------------------------------------------------------------------------------------------//

}
