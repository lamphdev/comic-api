package lamph11.web.comic.endpoint;

import lamph11.web.comic.common.ResponseUtils;
import lamph11.web.comic.dto.UserDTO;
import lamph11.web.comic.dto.response.ApiResponse;
import lamph11.web.comic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping("/me")
    public Mono<ApiResponse<UserDTO>> getCurrentUser(@AuthenticationPrincipal String username) {
        return Mono.fromCallable(() -> userService.getUserDetail(username))
                .map(Optional::get)
                .map(ResponseUtils::wrap)
                .publishOn(Schedulers.boundedElastic());
    }

}
