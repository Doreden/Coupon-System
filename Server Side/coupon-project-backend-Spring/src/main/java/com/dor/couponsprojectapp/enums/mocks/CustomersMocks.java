package com.dor.couponsprojectapp.enums.mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

// Mocks for creating the Customers in the database.
public enum CustomersMocks {
    DOR("dor", "eden", "dor@gmail.com", "dor123"),
    IDAN("idan", "kakon", "idan@gmail.com", "idan123"),
    OR("or", "chen", "or@gmail.com", "or123"),
    DANIEL("daniel", "perez", "daniel@gmail.com", "daniel123"),
    OMER("omer", "tito", "omer@gmail.com", "omer123"),
    DAVID("david", "bar-yosef", "david@gmail.com", "david123"),
    MEITAL("meital", "mor", "meital@gmail.com", "meital123"),
    EMIL("emilio", "bugadev", "emilio@gmail.com", "emilio123"),
    NITAY("nitay", "caspi", "nitay@gmail.com", "nitay123"),
    LIOR("lior", "cohen", "lior@gmial.com", "lior123"),
    TANYA("tanya", "kuper", "tanya@gmail.com", "tanya123");

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

}
