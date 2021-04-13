package pers.qjw.admin.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Map;

public class JwtUtil {

    private final static String key = TextCodec.BASE64.encode("6D231C94EB34E2DDE2BCF6200B4863D7");

    public static String createToken(Map<String, Object> data) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)
                .setClaims(data)
                .compact();
    }

    public static Map<String, Object> parsing(String token) {
        return Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}
