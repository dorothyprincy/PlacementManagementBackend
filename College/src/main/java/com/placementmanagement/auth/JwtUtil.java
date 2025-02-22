package com.placementmanagement.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {
   // Use a more secure key for production
   private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

   // Generate JWT Token
   public String generateToken(String username) {
       return Jwts.builder()
               .setSubject(username)  // Subject (e.g., username)
               .setIssuedAt(new Date())  // Set the issued time
               .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
               .signWith(secretKey)  // Sign the JWT with the key
               .compact();  // Compact the JWT to a string
   }

   // Extract Username from JWT Token
   public String extractUsername(String token) {
       Claims claims = parseToken(token);  // Use the method that returns Claims directly
       return claims.getSubject();
   }

   // Check if Token is Expired
   public boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
   }

   // Extract Expiration Date from JWT Token
   public Date extractExpiration(String token) {
       Claims claims = parseToken(token);
       return claims.getExpiration();
   }

   // Validate Token
   public boolean validateToken(String token, String username) {
       return (username.equals(extractUsername(token)) && !isTokenExpired(token));
   }

   // Helper method to parse the JWT token
   private Claims parseToken(String token) {
       return Jwts.parserBuilder()
               .setSigningKey(secretKey)  // Set the signing key
               .build()  // Build the parser
               .parseClaimsJws(token)  // Parse the JWT token and get the claims
               .getBody();  // Get the body (Claims)
   }
}
