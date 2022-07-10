package lamph11.web.comic.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import lamph11.web.comic.dto.UserDTO;
import lamph11.web.comic.entity.UserInfo;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T16:47:52+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInfo toEntity(UserDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setId( DTO.getId() );
        userInfo.setEmail( DTO.getEmail() );
        userInfo.setHashPassword( DTO.getHashPassword() );
        userInfo.setStatus( DTO.getStatus() );
        userInfo.setCreatedDate( DTO.getCreatedDate() );

        return userInfo;
    }

    @Override
    public List<UserInfo> toEntity(List<UserDTO> DTO) {
        if ( DTO == null ) {
            return null;
        }

        List<UserInfo> list = new ArrayList<UserInfo>( DTO.size() );
        for ( UserDTO userDTO : DTO ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public UserDTO toDTO(UserInfo entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setHashPassword( entity.getHashPassword() );
        userDTO.setStatus( entity.getStatus() );
        userDTO.setCreatedDate( entity.getCreatedDate() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTO(List<UserInfo> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entity.size() );
        for ( UserInfo userInfo : entity ) {
            list.add( toDTO( userInfo ) );
        }

        return list;
    }
}
