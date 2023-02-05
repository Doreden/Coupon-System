package com.dor.couponsprojectapp.repositories;

import com.dor.couponsprojectapp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByEmail(final String email);


    Company findByEmail(final String email);

    boolean existsByName(final String name);

    boolean existsByEmailAndPassword(String email, String password);


}
