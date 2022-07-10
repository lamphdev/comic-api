package lamph11.web.comic.mapper;

import lamph11.web.comic.dto.PostDTO;
import lamph11.web.comic.dto.request.CreatePostRequest;
import lamph11.web.comic.dto.request.UpdatePostRequest;
import lamph11.web.comic.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends BaseMapper<Post, PostDTO> {

    Post fromRequest(CreatePostRequest request);

    Post fromRequest(UpdatePostRequest request);

}
