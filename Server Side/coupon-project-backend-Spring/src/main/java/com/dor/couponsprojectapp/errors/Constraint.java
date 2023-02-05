package com.dor.couponsprojectapp.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Using for Prepared Errors Messages For The Application Exceptions.

@RequiredArgsConstructor
public enum Constraint {

    BAD_CREDENTIALS("Cant Identifies Given Credentials"),
    START_DATE_BEFORE_END_DATE("End date cannot be before startDate!"),
    COUPON_EXPIRED("This Coupon Has Been Expired!"),


    INVALID_DATE("The inserted date of current coupon is invalid"),

    ENTITY_NOT_EXISTS(" does not exist!"),

    ENTITY_ALREADY_EXISTS(" already exists!"),
    ENTITY_ALREADY_EXISTS_BY_NAME(" This Name is Already Exist in the DB!"),

    INVALID_INPUT_FORMAT("Invalid input - Please input according to the correct format"),

    ENTITY_NAME_EXISTS("This company name already exists! It is not allowed to update a company name!"),
    ENTITY_NOT_FOUND("this entity does not exist!"),

    LIST_IS_EMPTY(" list is empty!"),

    COUPON_OUT_OF_STOCK("Coupon is out of stock!"),
    COUPONS_LIST_IS_EMPTY(" coupons list is empty!"),

    COUPONS_ALREADY_PURCHASED(" This coupon has been already purchased by this customer!"),

    COUPONS_CATEGORY_EMPTY("There Arent any Coupons exists under this Category!"),
    COUPONS_CATEGORY_EMPTY_FOR_CUSTOMER("Doesnt Have any Coupons exists under this Category!"),
    COUPONS_BY_PRICE_EMPTY_FOR_CUSTOMER("Doesnt Have any Coupons exists under this Price!"),
    COUPONS_CATEGORY_EMPTY_FOR_COMPANY("Doesnt Have any Coupons exists under this Category!"),
    COUPONS_BY_PRICE_EMPTY_FOR_COMPANY("Doesnt Have any Coupons exists under this Price!"),
    CATEGORY_IS_NOT_VALID("This Category is not a valid Category!"),
    PRICE_IS_NOT_VALID("This Price is not a valid, Price cannot be negative!"),
    WORNG_PASSWORD_OR_AND_EMAIL("Wrong Password or Email entered!"),

    THE_EMAIL_IS_NULL("The Email provided is empty!");


    @Getter
    private final String errorMsg;
}