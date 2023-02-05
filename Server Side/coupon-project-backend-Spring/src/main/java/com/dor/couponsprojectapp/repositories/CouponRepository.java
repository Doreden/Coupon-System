package com.dor.couponsprojectapp.repositories;

import com.dor.couponsprojectapp.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    boolean existsByTitle(final String title);

    List<Coupon> findCouponById(final Long customerID);
    List<Coupon> findCouponByCompanyId(final long companyId);
    List<Coupon> findByPriceLessThanEqual(double maxPrice);


}
