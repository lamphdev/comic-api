package lamph11.web.comic.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CreatePostRequest {

    @NotEmpty
    @Length(max = 300)
    private String title;

    @NotEmpty
    @Length(max = 300)
    private String seoPath;

    @NotEmpty
    @Length(max = 5000)
    private String content;

    @NotEmpty
    private String status;

    private Long seriesId;

    private List<Long> tagIds;

}
