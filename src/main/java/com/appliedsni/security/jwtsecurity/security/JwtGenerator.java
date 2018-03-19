package com.appliedsni.security.jwtsecurity.security;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.appliedsni.entity.User;

@Component
public class JwtGenerator {


    public String generate(User pUserDto) {

        Claims claims = Jwts.claims()
                .setSubject(pUserDto.getEmailAddress());
        claims.put("userId", String.valueOf(pUserDto.getEmailAddress()));
        claims.put("role", pUserDto.getProfile().toString());
        LocalDateTime currentTime = LocalDateTime.now();
        String token = Jwts.builder()
          .setClaims(claims)
          .setIssuer("")
          .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
          .setExpiration(Date.from(currentTime
              .plusMinutes(100)
              .atZone(ZoneId.systemDefault()).toInstant()))
          .signWith(SignatureAlgorithm.HS512, "youtube")
        .compact();
        
        return token;
        
        
    }
}
