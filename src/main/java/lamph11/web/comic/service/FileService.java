package lamph11.web.comic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
@Slf4j
public class FileService {

    private File uploadFolder;

    public Mono<String> upload(FilePart filePart) {
        String fileName = filePart.filename();
        File fileUpload = new File(uploadFolder, fileName);
        return filePart.transferTo(fileUpload)
                .thenReturn(fileName);

    }

    @PostConstruct
    private void createFolderUpload() {
        uploadFolder = new File("uploads");
        log.info("file upload stored in {}", uploadFolder.getAbsolutePath());
        if (uploadFolder.exists() && uploadFolder.isFile())
            uploadFolder.delete();
        uploadFolder.mkdirs();
    }

}
