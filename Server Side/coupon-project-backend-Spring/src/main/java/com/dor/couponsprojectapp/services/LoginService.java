package com.dor.couponsprojectapp.services;

import com.dor.couponsprojectapp.enums.tables.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    //Class Services:
    private final AdminService adminService;
    private final CompanyService companyService;
    private final CustomerService customerService;


    //-----------------------------------------------------------------------------------------------------------------//
    // Login Method:

    public boolean login(final String email, final String password) {
        if (adminService.login(email, password)) {
            log.info("Successfully Logged As " + Type.ADMIN);
            return true;
        } else if (companyService.login(email, password)) {
            log.info("Successfully Logged As " + Type.COMPANY);
            return true;
        } else if (customerService.login(email, password)) {
            log.info("Successfully Logged As " + Type.CUSTOMER);
            return true;
        }
        log.error("Login Failed!");
        return false;
    }

}
