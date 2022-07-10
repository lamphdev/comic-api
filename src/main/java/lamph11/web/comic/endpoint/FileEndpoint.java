package lamph11.web.comic.endpoint;

import lamph11.web.comic.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileEndpoint {

    private final FileService fileService;

    @PostMapping
    public Mono<String> upload(@RequestPart FilePart file) {
        return fileService.upload(file);
    }

}
