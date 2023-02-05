package com.dor.couponsprojectapp.tasks;

import com.dor.couponsprojectapp.model.Coupon;
import com.dor.couponsprojectapp.repositories.CouponRepository;
import com.dor.couponsprojectapp.services.CompanyService;
import com.dor.couponsprojectapp.utils.CouponDateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableScheduling
@RequiredArgsConstructor
@Slf4j

// This class is used to run a daily job.
// deleted Coupons that are expired.
public class DailyJobTask {
    private final CouponRepository couponRepository;
    private final CompanyService companyService;

    @Scheduled(fixedDelay = 86400000)
    public void deleteExpiredCoupons() {

        List<Coupon> coupons = couponRepository.findAll();

        log.info("Thread: " + Thread.currentThread().getName() + " started to run");

        for (Coupon coupon : coupons) {

            if (CouponDateUtil.isCouponExpired(coupon.getEndDate())) {

                try {
                    companyService.deleteCoupon(coupon.getId());
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

                log.info("The coupon: " + coupon.getTitle() +
                        " has been deleted due to its expiration date: " + coupon.getEndDate());
            }
        }
    }

}
