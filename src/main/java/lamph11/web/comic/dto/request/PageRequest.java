package lamph11.web.comic.dto.request;

import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class PageRequest {

    protected int page;
    protected int size;

    public Pageable pageable() {
        if (page < 0)
            page = 0;
        if (size <= 0)
            size = 50;

        return org.springframework.data.domain.PageRequest.of(page, size);
    }
}
