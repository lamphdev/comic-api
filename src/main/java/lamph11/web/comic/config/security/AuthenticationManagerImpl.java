package lamph11.web.comic.config.security;

import lamph11.web.comic.common.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerImpl implements ReactiveAuthenticationManager {

    private final TokenUtils tokenUtils;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.justOrEmpty(authentication)
                .ofType(BearerTokenAuthenticationToken.class)
                .map(auth -> auth.getToken())
                .flatMap(this::readToken);
    }

    private Mono<Authentication> readToken(String token) {
        try {
            String username = tokenUtils.readToken(token);
            return Mono.just(new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList()));
        } catch (Exception e) {
            return Mono.empty();
        }
    }

}
