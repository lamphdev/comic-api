package lamph11.web.comic.common;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Component
public class TokenUtils {

    private static KeyPair keyPair;

    @PostConstruct
    public void generateKey() {
        keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
    }

    public String generateToken(String subject, Map<String, Object> data, Instant now, Long lifeTime) {
        return Jwts.builder()
                .signWith(keyPair.getPrivate())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(lifeTime)))
                .setSubject(subject)
                .addClaims(data)
                .compact();
    }

    public String readToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(keyPair.getPublic())
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

}
