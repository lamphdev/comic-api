package lamph11.web.comic.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class PostDTO {

    private Long id;

    private String title;

    private String seoPath;

    private String content;

    private String status;

    private Instant createdDate;

    private Instant updatedDate;

    private Long seriesId;

}
