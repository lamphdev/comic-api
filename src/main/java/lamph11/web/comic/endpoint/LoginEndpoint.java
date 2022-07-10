package lamph11.web.comic.endpoint;

import lamph11.web.comic.common.ResponseUtils;
import lamph11.web.comic.dto.response.ApiResponse;
import lamph11.web.comic.dto.request.LoginRequest;
import lamph11.web.comic.dto.response.LoginResponse;
import lamph11.web.comic.dto.request.RefreshTokenRequest;
import lamph11.web.comic.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginEndpoint {

    private final LoginService loginService;

    @PostMapping(name = "login with username and password")
    public Mono<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        return Mono.fromCallable(() -> loginService.loginWithAccount(request))
                .map(ResponseUtils::wrap)
                .publishOn(Schedulers.boundedElastic());
    }

    @PostMapping(value = "/refresh", name = "refresh token")
    public Mono<ApiResponse<LoginResponse>> refreshToken(@Valid @ModelAttribute RefreshTokenRequest request) {
        return Mono.fromCallable(() -> loginService.refreshToken(request))
                .map(ResponseUtils::wrap)
                .publishOn(Schedulers.boundedElastic());
    }
}
