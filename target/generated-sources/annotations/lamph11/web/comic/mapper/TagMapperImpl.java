package lamph11.web.comic.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import lamph11.web.comic.dto.TagDTO;
import lamph11.web.comic.entity.Tag;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T16:33:28+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toEntity(TagDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( DTO.getId() );
        tag.setName( DTO.getName() );
        tag.setDescription( DTO.getDescription() );

        return tag;
    }

    @Override
    public List<Tag> toEntity(List<TagDTO> DTO) {
        if ( DTO == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( DTO.size() );
        for ( TagDTO tagDTO : DTO ) {
            list.add( toEntity( tagDTO ) );
        }

        return list;
    }

    @Override
    public TagDTO toDTO(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();

        tagDTO.setId( entity.getId() );
        tagDTO.setName( entity.getName() );
        tagDTO.setDescription( entity.getDescription() );

        return tagDTO;
    }

    @Override
    public List<TagDTO> toDTO(List<Tag> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TagDTO> list = new ArrayList<TagDTO>( entity.size() );
        for ( Tag tag : entity ) {
            list.add( toDTO( tag ) );
        }

        return list;
    }
}
