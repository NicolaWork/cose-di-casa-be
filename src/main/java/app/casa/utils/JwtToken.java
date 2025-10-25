package app.casa.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtToken {
    private static final String SECRET_KEY = "hP6g6nWZQ3N9zvZ8xJX4m0yU8t2uB5kAq1R7Vd9C3Fg=";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generaToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+60 * 60 * 1000)) // validità di 1 ora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String estraiEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validazioneToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }
}
