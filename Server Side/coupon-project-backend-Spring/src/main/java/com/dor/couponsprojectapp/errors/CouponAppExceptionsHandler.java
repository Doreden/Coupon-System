package com.dor.couponsprojectapp.errors;

import com.dor.couponsprojectapp.dto.ResponseDTO;
import com.dor.couponsprojectapp.errors.exceptions.AuthException;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// This class is used to handle all exceptions that are thrown in the application.
@RestControllerAdvice
public class CouponAppExceptionsHandler {

    @ExceptionHandler(CouponAppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO couponAppExceptionHandler(CouponAppException couponAppException) {
        return new ResponseDTO(false, couponAppException.getMessage());
    }

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseDTO authExceptionHandler(AuthException authException) {
        return new ResponseDTO(false, authException.getMessage());
    }
}
