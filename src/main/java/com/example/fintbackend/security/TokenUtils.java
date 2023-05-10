package com.example.fintbackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class TokenUtils {
    private final static String TOKEN_ACCESS = "waP5dFCBk8Lvhe2e3EU4bdpF6CNgd7bW2Nc9ixZd";
    private final static Long ACCESS_TOKEN_TIME = 3600L;

    public static String createToken(String name, String email){
        long expirationTime = ACCESS_TOKEN_TIME * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = Map.of("name", name);

        return Jwts
                .builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(TOKEN_ACCESS.getBytes())).compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(TOKEN_ACCESS.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}
