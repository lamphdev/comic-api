package lamph11.web.comic.mapper;

import lamph11.web.comic.dto.UserDTO;
import lamph11.web.comic.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserInfo, UserDTO> {
}
