package com.dor.couponsprojectapp.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

// General Error Message
public class ErrorMessage {

    private String errorMsg;
}
