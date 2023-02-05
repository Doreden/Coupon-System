package com.dor.couponsprojectapp.repositories;

import com.dor.couponsprojectapp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByEmail(final String email);
}
