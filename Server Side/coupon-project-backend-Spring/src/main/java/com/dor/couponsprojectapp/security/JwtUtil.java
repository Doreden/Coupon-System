package com.dor.couponsprojectapp.security;

import com.dor.couponsprojectapp.dto.UserDTO;
import com.dor.couponsprojectapp.enums.tables.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtil {
    private static final int ONE_HOUR_IN_MILLIS = 1000 * 60 * 60;
    public static final String SECRET_KEY = "secret";

    public static String extractEmail(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(final String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(final String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(final String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public static String generateToken(final long id,final String email, final Role role) {
        final Map<String, Object> claims = new HashMap<>();
        UserDTO userDTO = new UserDTO(id,email, role);
        claims.put("user", userDTO);
        return createToken(claims, email);
    }

    public static String generateTokenCompany(final long id,final String email,final String name,final Role role) {
        final Map<String, Object> claims = new HashMap<>();
        UserDTO userDTO = new UserDTO(id,email,name,role);
        claims.put("user", userDTO);
        return createToken(claims, email);
    }
    public static String generateTokenCustomer(final long id,final String email,final String firstName, String lastName, final Role role) {
        final Map<String, Object> claims = new HashMap<>();
        UserDTO userDTO = new UserDTO(id,email,firstName,lastName,role);
        claims.put("user", userDTO);
        return createToken(claims, email);
    }

    private static String createToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ONE_HOUR_IN_MILLIS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static boolean validateToken(final String token, final UserDetails user) {
        final String email = extractEmail(token);
        return email.equals(user.getUsername()) && !isTokenExpired(token);
    }

    private static boolean isTokenExpired(final String token) {
        return extractExpiration(token).before(new Date());
    }


}
