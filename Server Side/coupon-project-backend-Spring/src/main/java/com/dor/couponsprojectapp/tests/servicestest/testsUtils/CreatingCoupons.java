package com.dor.couponsprojectapp.tests.servicestest.testsUtils;

import com.dor.couponsprojectapp.dto.CouponDTO;
import com.dor.couponsprojectapp.enums.mocks.CouponsMocks;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatingCoupons {

    public static CouponDTO ampmCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.AMPM.getCompanyID())
                .category(CouponsMocks.AMPM.getCategory())
                .title(CouponsMocks.AMPM.getTitle())
                .description(CouponsMocks.AMPM.getDescription())
                .startDate(CouponsMocks.AMPM.getStartDate())
                .endDate(CouponsMocks.AMPM.getEndDate())
                .amount(CouponsMocks.AMPM.getAmount())
                .price(CouponsMocks.AMPM.getPrice())
                .image(CouponsMocks.AMPM.getImage())
                .build();
    }


    public static CouponDTO ampm2CouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.AMPM2.getCompanyID())
                .category(CouponsMocks.AMPM2.getCategory())
                .title(CouponsMocks.AMPM2.getTitle())
                .description(CouponsMocks.AMPM2.getDescription())
                .startDate(CouponsMocks.AMPM2.getStartDate())
                .endDate(CouponsMocks.AMPM2.getEndDate())
                .amount(CouponsMocks.AMPM2.getAmount())
                .price(CouponsMocks.AMPM2.getPrice())
                .image(CouponsMocks.AMPM2.getImage())
                .build();
    }

    public static CouponDTO superYudaCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.SUPERYUDA.getCompanyID())
                .category(CouponsMocks.SUPERYUDA.getCategory())
                .title(CouponsMocks.SUPERYUDA.getTitle())
                .description(CouponsMocks.SUPERYUDA.getDescription())
                .startDate(CouponsMocks.SUPERYUDA.getStartDate())
                .endDate(CouponsMocks.SUPERYUDA.getEndDate())
                .amount(CouponsMocks.SUPERYUDA.getAmount())
                .price(CouponsMocks.SUPERYUDA.getPrice())
                .image(CouponsMocks.SUPERYUDA.getImage())
                .build();
    }

    public static CouponDTO superYuda2CouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.SUPERYUDA2.getCompanyID())
                .category(CouponsMocks.SUPERYUDA2.getCategory())
                .title(CouponsMocks.SUPERYUDA2.getTitle())
                .description(CouponsMocks.SUPERYUDA2.getDescription())
                .startDate(CouponsMocks.SUPERYUDA2.getStartDate())
                .endDate(CouponsMocks.SUPERYUDA2.getEndDate())
                .amount(CouponsMocks.SUPERYUDA2.getAmount())
                .price(CouponsMocks.SUPERYUDA2.getPrice())
                .image(CouponsMocks.SUPERYUDA2.getImage())
                .build();
    }

    public static CouponDTO dominosCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.DOMINOS.getCompanyID())
                .category(CouponsMocks.DOMINOS.getCategory())
                .title(CouponsMocks.DOMINOS.getTitle())
                .description(CouponsMocks.DOMINOS.getDescription())
                .startDate(CouponsMocks.DOMINOS.getStartDate())
                .endDate(CouponsMocks.DOMINOS.getEndDate())
                .amount(CouponsMocks.DOMINOS.getAmount())
                .price(CouponsMocks.DOMINOS.getPrice())
                .image(CouponsMocks.DOMINOS.getImage())
                .build();
    }

    public static CouponDTO mcdonaldsCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.MCDONALDS.getCompanyID())
                .category(CouponsMocks.MCDONALDS.getCategory())
                .title(CouponsMocks.MCDONALDS.getTitle())
                .description(CouponsMocks.MCDONALDS.getDescription())
                .startDate(CouponsMocks.MCDONALDS.getStartDate())
                .endDate(CouponsMocks.MCDONALDS.getEndDate())
                .amount(CouponsMocks.MCDONALDS.getAmount())
                .price(CouponsMocks.MCDONALDS.getPrice())
                .image(CouponsMocks.MCDONALDS.getImage())
                .build();
    }

    public static CouponDTO shupersalCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.SHUPERSAL.getCompanyID())
                .category(CouponsMocks.SHUPERSAL.getCategory())
                .title(CouponsMocks.SHUPERSAL.getTitle())
                .description(CouponsMocks.SHUPERSAL.getDescription())
                .startDate(CouponsMocks.SHUPERSAL.getStartDate())
                .endDate(CouponsMocks.SHUPERSAL.getEndDate())
                .amount(CouponsMocks.SHUPERSAL.getAmount())
                .price(CouponsMocks.SHUPERSAL.getPrice())
                .image(CouponsMocks.SHUPERSAL.getImage())
                .build();
    }

    public static CouponDTO osheradCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.OSHERAD.getCompanyID())
                .category(CouponsMocks.OSHERAD.getCategory())
                .title(CouponsMocks.OSHERAD.getTitle())
                .description(CouponsMocks.OSHERAD.getDescription())
                .startDate(CouponsMocks.OSHERAD.getStartDate())
                .endDate(CouponsMocks.OSHERAD.getEndDate())
                .amount(CouponsMocks.OSHERAD.getAmount())
                .price(CouponsMocks.OSHERAD.getPrice())
                .image(CouponsMocks.OSHERAD.getImage())
                .build();
    }

    public static CouponDTO ivoryCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.IVORY.getCompanyID())
                .category(CouponsMocks.IVORY.getCategory())
                .title(CouponsMocks.IVORY.getTitle())
                .description(CouponsMocks.IVORY.getDescription())
                .startDate(CouponsMocks.IVORY.getStartDate())
                .endDate(CouponsMocks.IVORY.getEndDate())
                .amount(CouponsMocks.IVORY.getAmount())
                .price(CouponsMocks.IVORY.getPrice())
                .image(CouponsMocks.IVORY.getImage())
                .build();
    }

    public static CouponDTO kspCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.KSP.getCompanyID())
                .category(CouponsMocks.KSP.getCategory())
                .title(CouponsMocks.KSP.getTitle())
                .description(CouponsMocks.KSP.getDescription())
                .startDate(CouponsMocks.KSP.getStartDate())
                .endDate(CouponsMocks.KSP.getEndDate())
                .amount(CouponsMocks.KSP.getAmount())
                .price(CouponsMocks.KSP.getPrice())
                .image(CouponsMocks.KSP.getImage())
                .build();
    }


    public static CouponDTO yelpCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.YELP.getCompanyID())
                .category(CouponsMocks.YELP.getCategory())
                .title(CouponsMocks.YELP.getTitle())
                .description(CouponsMocks.YELP.getDescription())
                .startDate(CouponsMocks.YELP.getStartDate())
                .endDate(CouponsMocks.YELP.getEndDate())
                .amount(CouponsMocks.YELP.getAmount())
                .price(CouponsMocks.YELP.getPrice())
                .image(CouponsMocks.YELP.getImage())
                .build();
    }

    public static CouponDTO tripAdvisorCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.TRIPADVISOR.getCompanyID())
                .category(CouponsMocks.TRIPADVISOR.getCategory())
                .title(CouponsMocks.TRIPADVISOR.getTitle())
                .description(CouponsMocks.TRIPADVISOR.getDescription())
                .startDate(CouponsMocks.TRIPADVISOR.getStartDate())
                .endDate(CouponsMocks.TRIPADVISOR.getEndDate())
                .amount(CouponsMocks.TRIPADVISOR.getAmount())
                .price(CouponsMocks.TRIPADVISOR.getPrice())
                .image(CouponsMocks.TRIPADVISOR.getImage())
                .build();
    }

    public static CouponDTO airbnbCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.AIRBNB.getCompanyID())
                .category(CouponsMocks.AIRBNB.getCategory())
                .title(CouponsMocks.AIRBNB.getTitle())
                .description(CouponsMocks.AIRBNB.getDescription())
                .startDate(CouponsMocks.AIRBNB.getStartDate())
                .endDate(CouponsMocks.AIRBNB.getEndDate())
                .amount(CouponsMocks.AIRBNB.getAmount())
                .price(CouponsMocks.AIRBNB.getPrice())
                .image(CouponsMocks.AIRBNB.getImage())
                .build();
    }

public static CouponDTO bookingCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.BOOKING.getCompanyID())
                .category(CouponsMocks.BOOKING.getCategory())
                .title(CouponsMocks.BOOKING.getTitle())
                .description(CouponsMocks.BOOKING.getDescription())
                .startDate(CouponsMocks.BOOKING.getStartDate())
                .endDate(CouponsMocks.BOOKING.getEndDate())
                .amount(CouponsMocks.BOOKING.getAmount())
                .price(CouponsMocks.BOOKING.getPrice())
                .image(CouponsMocks.BOOKING.getImage())
                .build();
    }

    public static CouponDTO haceremCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.HACEREM.getCompanyID())
                .category(CouponsMocks.HACEREM.getCategory())
                .title(CouponsMocks.HACEREM.getTitle())
                .description(CouponsMocks.HACEREM.getDescription())
                .startDate(CouponsMocks.HACEREM.getStartDate())
                .endDate(CouponsMocks.HACEREM.getEndDate())
                .amount(CouponsMocks.HACEREM.getAmount())
                .price(CouponsMocks.HACEREM.getPrice())
                .image(CouponsMocks.HACEREM.getImage())
                .build();
    }

    public static CouponDTO cocaColaCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.COCACOLA.getCompanyID())
                .category(CouponsMocks.COCACOLA.getCategory())
                .title(CouponsMocks.COCACOLA.getTitle())
                .description(CouponsMocks.COCACOLA.getDescription())
                .startDate(CouponsMocks.COCACOLA.getStartDate())
                .endDate(CouponsMocks.COCACOLA.getEndDate())
                .amount(CouponsMocks.COCACOLA.getAmount())
                .price(CouponsMocks.COCACOLA.getPrice())
                .image(CouponsMocks.COCACOLA.getImage())
                .build();
    }

    public static CouponDTO adidasCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.ADIDAS.getCompanyID())
                .category(CouponsMocks.ADIDAS.getCategory())
                .title(CouponsMocks.ADIDAS.getTitle())
                .description(CouponsMocks.ADIDAS.getDescription())
                .startDate(CouponsMocks.ADIDAS.getStartDate())
                .endDate(CouponsMocks.ADIDAS.getEndDate())
                .amount(CouponsMocks.ADIDAS.getAmount())
                .price(CouponsMocks.ADIDAS.getPrice())
                .image(CouponsMocks.ADIDAS.getImage())
                .build();
    }

    public static CouponDTO castroCouponCreate() {
        return CouponDTO.builder()
                .companyId(CouponsMocks.CASTRO.getCompanyID())
                .category(CouponsMocks.CASTRO.getCategory())
                .title(CouponsMocks.CASTRO.getTitle())
                .description(CouponsMocks.CASTRO.getDescription())
                .startDate(CouponsMocks.CASTRO.getStartDate())
                .endDate(CouponsMocks.CASTRO.getEndDate())
                .amount(CouponsMocks.CASTRO.getAmount())
                .price(CouponsMocks.CASTRO.getPrice())
                .image(CouponsMocks.CASTRO.getImage())
                .build();
    }

}
