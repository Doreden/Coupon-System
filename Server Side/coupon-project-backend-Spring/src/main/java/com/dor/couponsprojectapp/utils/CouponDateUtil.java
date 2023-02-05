package com.dor.couponsprojectapp.utils;

import com.dor.couponsprojectapp.model.Coupon;

import java.time.LocalDate;

public class CouponDateUtil {


    //This method is decreasing a specific coupon amount by 1
    public static void decreaseCouponAmount(final Coupon coupon) {
        int prevAmount = coupon.getAmount();
        coupon.setAmount(prevAmount - 1);
    }

    //This method is checking if a coupon end date is expired
    public static boolean isCouponExpired(final LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

}
