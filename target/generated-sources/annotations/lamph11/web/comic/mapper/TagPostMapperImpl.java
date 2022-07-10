package lamph11.web.comic.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import lamph11.web.comic.dto.PostDTO;
import lamph11.web.comic.dto.TagDTO;
import lamph11.web.comic.dto.TagPostDTO;
import lamph11.web.comic.entity.Post;
import lamph11.web.comic.entity.Tag;
import lamph11.web.comic.entity.TagPost;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T16:33:28+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class TagPostMapperImpl implements TagPostMapper {

    @Override
    public TagPost toEntity(TagPostDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Tag tag = null;
        Post post = null;

        tag = tagDTOToTag( DTO.getTag() );
        post = postDTOToPost( DTO.getPost() );

        TagPost tagPost = new TagPost( tag, post );

        tagPost.setId( DTO.getId() );

        return tagPost;
    }

    @Override
    public List<TagPost> toEntity(List<TagPostDTO> DTO) {
        if ( DTO == null ) {
            return null;
        }

        List<TagPost> list = new ArrayList<TagPost>( DTO.size() );
        for ( TagPostDTO tagPostDTO : DTO ) {
            list.add( toEntity( tagPostDTO ) );
        }

        return list;
    }

    @Override
    public TagPostDTO toDTO(TagPost entity) {
        if ( entity == null ) {
            return null;
        }

        TagPostDTO tagPostDTO = new TagPostDTO();

        tagPostDTO.setId( entity.getId() );
        tagPostDTO.setTag( tagToTagDTO( entity.getTag() ) );
        tagPostDTO.setPost( postToPostDTO( entity.getPost() ) );

        return tagPostDTO;
    }

    @Override
    public List<TagPostDTO> toDTO(List<TagPost> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TagPostDTO> list = new ArrayList<TagPostDTO>( entity.size() );
        for ( TagPost tagPost : entity ) {
            list.add( toDTO( tagPost ) );
        }

        return list;
    }

    protected Tag tagDTOToTag(TagDTO tagDTO) {
        if ( tagDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagDTO.getId() );
        tag.setName( tagDTO.getName() );
        tag.setDescription( tagDTO.getDescription() );

        return tag;
    }

    protected Post postDTOToPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setTitle( postDTO.getTitle() );
        post.setSeoPath( postDTO.getSeoPath() );
        post.setContent( postDTO.getContent() );
        post.setStatus( postDTO.getStatus() );
        post.setCreatedDate( postDTO.getCreatedDate() );
        post.setUpdatedDate( postDTO.getUpdatedDate() );

        return post;
    }

    protected TagDTO tagToTagDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();

        tagDTO.setId( tag.getId() );
        tagDTO.setName( tag.getName() );
        tagDTO.setDescription( tag.getDescription() );

        return tagDTO;
    }

    protected PostDTO postToPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setTitle( post.getTitle() );
        postDTO.setSeoPath( post.getSeoPath() );
        postDTO.setContent( post.getContent() );
        postDTO.setStatus( post.getStatus() );
        postDTO.setCreatedDate( post.getCreatedDate() );
        postDTO.setUpdatedDate( post.getUpdatedDate() );

        return postDTO;
    }
}
