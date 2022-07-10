package lamph11.web.comic.endpoint;

import lamph11.web.comic.common.ResponseUtils;
import lamph11.web.comic.dto.PostDTO;
import lamph11.web.comic.dto.request.CreatePostRequest;
import lamph11.web.comic.dto.request.UpdatePostRequest;
import lamph11.web.comic.dto.response.ApiResponse;
import lamph11.web.comic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostEndpoint {

    private final PostService postService;

    @PostMapping(name = "create post")
    public Mono<ApiResponse<PostDTO>> create(@Valid @RequestBody CreatePostRequest request) {
        return Mono.fromCallable(() -> postService.create(request))
                .map(ResponseUtils::wrap)
                .publishOn(Schedulers.boundedElastic());
    }

    @PutMapping(name = "edit post")
    public Mono<ApiResponse<PostDTO>> edit(@Valid @RequestBody UpdatePostRequest request) {
        return Mono.fromCallable(() -> postService.update(request))
                .map(ResponseUtils::wrap)
                .publishOn(Schedulers.boundedElastic());
    }

}
