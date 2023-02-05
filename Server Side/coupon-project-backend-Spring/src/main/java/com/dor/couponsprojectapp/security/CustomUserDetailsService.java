package com.dor.couponsprojectapp.security;

import com.dor.couponsprojectapp.repositories.CompanyRepository;
import com.dor.couponsprojectapp.repositories.CustomerRepository;
import com.dor.couponsprojectapp.utils.ObjectsMappingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    // Class Repository:
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;

    //Load By Username Method:
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

        // Check if the given email contain something!
        if (email == null) {
            throw new UsernameNotFoundException("The Email provided is empty!");
        }

        // In Case Of the Username is Admin:
        if (email.equals("admin@admin.com")) {
            return new User(
                    "admin@admin.com",
                    "admin",
                    new ArrayList<>()
            );
        }

        // In case Of the Username is Company:
        if (companyRepository.existsByEmail(email)) {
            var username = companyRepository.findByEmail(email);
            return ObjectsMappingUtil.companyToSpringSecurityUser(username);
        }

        // In case Of the Username is Customer:
        customerRepository.existsByEmail(email);
        var username = customerRepository.findByEmail(email);
        return ObjectsMappingUtil.customerToSpringSecurityUser(username);

    }



}
