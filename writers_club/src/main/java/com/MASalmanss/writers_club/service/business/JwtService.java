package com.MASalmanss.writers_club.service.business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>() , userDetails );
    }
    public String generateToken(HashMap<String , Objects> extraClaims , UserDetails userDetails){
        return buildToken(extraClaims , userDetails , jwtExpiration);
    }
    public Long getExpiration(){
        return jwtExpiration;
    }


    private String buildToken(Map<String , Objects> extraClaims , UserDetails userDetails , long jwtExpiration){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration ))
                .signWith(getSignKey() , SignatureAlgorithm.HS256)
                .compact();
    }



    private Key getSignKey(){
        byte[] codes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(codes);
    }


    public String extractUsername(String token){
        return extractClaims(token , Claims::getSubject);
    }

    public boolean isTokenExpired(String token){
        return extractClaims(token , Claims::getExpiration).before(new Date());
    }

    public Date extractExpiration(String token){
        return extractClaims(token , Claims::getExpiration);
    }

    public boolean isTokenValid(String token , UserDetails userDetails){
        return extractClaims(token , Claims::getSubject).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public <T> T extractClaims(String token , Function<Claims , T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
