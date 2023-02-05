package com.dor.couponsprojectapp.services;

import com.dor.couponsprojectapp.dto.JwtDTO;
import com.dor.couponsprojectapp.dto.UserDTO;
import com.dor.couponsprojectapp.enums.tables.Role;
import com.dor.couponsprojectapp.enums.tables.Type;
import com.dor.couponsprojectapp.errors.Constraint;
import com.dor.couponsprojectapp.errors.exceptions.AuthException;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.model.Admin;
import com.dor.couponsprojectapp.model.Company;
import com.dor.couponsprojectapp.model.Customer;
import com.dor.couponsprojectapp.repositories.AdminRepository;
import com.dor.couponsprojectapp.repositories.CompanyRepository;
import com.dor.couponsprojectapp.repositories.CustomerRepository;
import com.dor.couponsprojectapp.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;

    private final AdminRepository adminRepository;

    public JwtDTO authenticate(final UserDTO user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            throw new AuthException("Wrong credentials Has Been entered!");
        } catch (final AuthException e) {
            log.error(e.getMessage());
        }

        if (user.getRole().equals(Role.COMPANY)) {
            Company company = companyRepository.findByEmail(user.getEmail());
            return new JwtDTO(JwtUtil.generateTokenCompany(company.getId(), company.getEmail(),company.getName(), Role.COMPANY));

        } else if (user.getRole().equals(Role.CUSTOMER)) {
            Customer customer = customerRepository.findByEmail(user.getEmail());
            return new JwtDTO(JwtUtil.generateTokenCustomer(customer.getId(), customer.getEmail(), customer.getFirstName(), customer.getLastName(), Role.CUSTOMER));

        } else if (user.getRole().equals(Role.ADMIN)) {
            Admin admin = adminRepository.findByEmail(user.getEmail());
            return new JwtDTO(JwtUtil.generateToken(admin.getId(),admin.getEmail() , admin.getRole()));
        }
        return null;
    }
}

