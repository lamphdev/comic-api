package lamph11.web.comic.mapper;

import lamph11.web.comic.dto.TagPostDTO;
import lamph11.web.comic.entity.TagPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagPostMapper extends BaseMapper<TagPost, TagPostDTO> {
}
