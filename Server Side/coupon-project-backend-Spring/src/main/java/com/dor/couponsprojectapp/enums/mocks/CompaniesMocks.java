package com.dor.couponsprojectapp.enums.mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

// Mocks for creating the companies in the database.
public enum CompaniesMocks {
    AMPM("AMPM", "service@ampm.com", "ampm123"),
    SUPERYUDA("Superyuda","marketing@superyuda.co.il","yuda123"),
    DOMINOS("Dominos","marketing@dominos.com","dominos123"),
    MCDONALDS("McDonald","sales@mcdonalds.com","mcdonalds123"),
    SHUPERSAL("Shupersal","sales@shupersal.co.il","shupersal123"),
    OSHERAD("Osherad","basad@osherad.co.il","osherad123"),
    IVORY("Ivory","sales&marketing@ivory.co.il","ivory123"),
    KSP("KSP","sales&marketing@ksp.co.il","ksp123"),
    YELP("Yelp","marketing@yelp.com","ksp123"),
    TRIPADVISOR("TripAdvisor","sales@tripadvisor.com","tripadvisor123"),
    AIRBNB("Airbnb","sales&housing@airbnb.com","airbnb123"),
    BOOKING("Booking","sales&flight@booking.com","booking123"),
    HACEREM("Hacerem","sales@hacerem.com","hacerem123"),

    COCACOLA("Coca Cola","drinks&fun@cocacola.com","cola123"),
    ADIDAS("Adidas","sales&marketing@adidas.com","adidas123"),
    CASTRO("Castro","marketing@castro.com","castro123");

    private final String name;
    private final String email;
    private final String password;


}
