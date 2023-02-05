package com.dor.couponsprojectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// ResponseDTO is used to transfer data between the client and the server.

public class ResponseDTO {

    private boolean success;
    private String message;
}
