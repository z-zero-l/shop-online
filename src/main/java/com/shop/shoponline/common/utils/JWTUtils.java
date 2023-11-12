package com.shop.shoponline.common.utils;

import io.jsonwebtoken.*;

import java.util.Map;

public class JWTUtils {

    /**
     * 生成token
     *
     * @param secret
     * @param claims
     * @return String
     */
    public static String generateToken(String secret, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static Map getClaims(String secret, String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return claims.getBody();
        } catch (MissingClaimException | IncorrectClaimException e) {
            e.printStackTrace();
        }
        return null;
    }
}
