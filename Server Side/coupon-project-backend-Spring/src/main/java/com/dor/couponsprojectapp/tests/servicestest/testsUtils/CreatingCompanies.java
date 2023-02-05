package com.dor.couponsprojectapp.tests.servicestest.testsUtils;

import com.dor.couponsprojectapp.dto.CompanyDTO;
import com.dor.couponsprojectapp.enums.mocks.CompaniesMocks;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatingCompanies {

    public static CompanyDTO ampmCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.AMPM.getName())
                .password(CompaniesMocks.AMPM.getPassword())
                .email(CompaniesMocks.AMPM.getEmail())
                .build();
    }

    public static CompanyDTO superYudaCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.SUPERYUDA.getName())
                .password(CompaniesMocks.SUPERYUDA.getPassword())
                .email(CompaniesMocks.SUPERYUDA.getEmail())
                .build();
    }

    public static CompanyDTO dominosCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.DOMINOS.getName())
                .password(CompaniesMocks.DOMINOS.getPassword())
                .email(CompaniesMocks.DOMINOS.getEmail())
                .build();
    }

    public static CompanyDTO mcdonaldsCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.MCDONALDS.getName())
                .password(CompaniesMocks.MCDONALDS.getPassword())
                .email(CompaniesMocks.MCDONALDS.getEmail())
                .build();
    }

    public static CompanyDTO shupersalCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.SHUPERSAL.getName())
                .password(CompaniesMocks.SHUPERSAL.getPassword())
                .email(CompaniesMocks.SHUPERSAL.getEmail())
                .build();
    }

    public static CompanyDTO osheradCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.OSHERAD.getName())
                .password(CompaniesMocks.OSHERAD.getPassword())
                .email(CompaniesMocks.OSHERAD.getEmail())
                .build();
    }

    public static CompanyDTO ivoryCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.IVORY.getName())
                .password(CompaniesMocks.IVORY.getPassword())
                .email(CompaniesMocks.IVORY.getEmail())
                .build();
    }

    public static CompanyDTO kspCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.KSP.getName())
                .password(CompaniesMocks.KSP.getPassword())
                .email(CompaniesMocks.KSP.getEmail())
                .build();
    }

    public static CompanyDTO yelpCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.YELP.getName())
                .password(CompaniesMocks.YELP.getPassword())
                .email(CompaniesMocks.YELP.getEmail())
                .build();
    }

    public static CompanyDTO tripadvisorCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.TRIPADVISOR.getName())
                .password(CompaniesMocks.TRIPADVISOR.getPassword())
                .email(CompaniesMocks.TRIPADVISOR.getEmail())
                .build();
    }

    public static CompanyDTO airbnbCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.AIRBNB.getName())
                .password(CompaniesMocks.AIRBNB.getPassword())
                .email(CompaniesMocks.AIRBNB.getEmail())
                .build();
    }

    public static CompanyDTO bookingCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.BOOKING.getName())
                .password(CompaniesMocks.BOOKING.getPassword())
                .email(CompaniesMocks.BOOKING.getEmail())
                .build();
    }

    public static CompanyDTO haceremCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.HACEREM.getName())
                .password(CompaniesMocks.HACEREM.getPassword())
                .email(CompaniesMocks.HACEREM.getEmail())
                .build();
    }

    public static CompanyDTO cocaColaCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.COCACOLA.getName())
                .password(CompaniesMocks.COCACOLA.getPassword())
                .email(CompaniesMocks.COCACOLA.getEmail())
                .build();
    }

    public static CompanyDTO adidasCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.ADIDAS.getName())
                .password(CompaniesMocks.ADIDAS.getPassword())
                .email(CompaniesMocks.ADIDAS.getEmail())
                .build();
    }

    public static CompanyDTO castroCompanyCreate() {
        return CompanyDTO.builder()
                .name(CompaniesMocks.CASTRO.getName())
                .password(CompaniesMocks.CASTRO.getPassword())
                .email(CompaniesMocks.CASTRO.getEmail())
                .build();
    }

}



