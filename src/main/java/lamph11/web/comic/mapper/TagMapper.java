package lamph11.web.comic.mapper;

import lamph11.web.comic.dto.TagDTO;
import lamph11.web.comic.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper extends BaseMapper<Tag, TagDTO> {
}
