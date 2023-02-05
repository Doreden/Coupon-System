package com.dor.couponsprojectapp.controllers;

import com.dor.couponsprojectapp.dto.JwtDTO;
import com.dor.couponsprojectapp.dto.ResponseDTO;
import com.dor.couponsprojectapp.dto.UserDTO;
import com.dor.couponsprojectapp.errors.exceptions.AuthException;
import com.dor.couponsprojectapp.errors.exceptions.CouponAppException;
import com.dor.couponsprojectapp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public JwtDTO loginWeb(@RequestBody final UserDTO userDTO) throws AuthException  {
        return authService.authenticate(userDTO);

    }
}
