package lamph11.web.comic.dto;

import lombok.Data;

@Data
public class TagPostDTO {

    private  Long id;

    private TagDTO tag;

    private PostDTO post;
}
