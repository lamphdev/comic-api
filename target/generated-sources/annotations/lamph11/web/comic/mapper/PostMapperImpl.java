package lamph11.web.comic.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import lamph11.web.comic.dto.PostDTO;
import lamph11.web.comic.dto.request.CreatePostRequest;
import lamph11.web.comic.dto.request.UpdatePostRequest;
import lamph11.web.comic.entity.Post;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T16:33:28+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toEntity(PostDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( DTO.getId() );
        post.setTitle( DTO.getTitle() );
        post.setSeoPath( DTO.getSeoPath() );
        post.setContent( DTO.getContent() );
        post.setStatus( DTO.getStatus() );
        post.setCreatedDate( DTO.getCreatedDate() );
        post.setUpdatedDate( DTO.getUpdatedDate() );

        return post;
    }

    @Override
    public List<Post> toEntity(List<PostDTO> DTO) {
        if ( DTO == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( DTO.size() );
        for ( PostDTO postDTO : DTO ) {
            list.add( toEntity( postDTO ) );
        }

        return list;
    }

    @Override
    public PostDTO toDTO(Post entity) {
        if ( entity == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( entity.getId() );
        postDTO.setTitle( entity.getTitle() );
        postDTO.setSeoPath( entity.getSeoPath() );
        postDTO.setContent( entity.getContent() );
        postDTO.setStatus( entity.getStatus() );
        postDTO.setCreatedDate( entity.getCreatedDate() );
        postDTO.setUpdatedDate( entity.getUpdatedDate() );

        return postDTO;
    }

    @Override
    public List<PostDTO> toDTO(List<Post> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( entity.size() );
        for ( Post post : entity ) {
            list.add( toDTO( post ) );
        }

        return list;
    }

    @Override
    public Post fromRequest(CreatePostRequest request) {
        if ( request == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( request.getTitle() );
        post.setSeoPath( request.getSeoPath() );
        post.setContent( request.getContent() );
        post.setStatus( request.getStatus() );

        return post;
    }

    @Override
    public Post fromRequest(UpdatePostRequest request) {
        if ( request == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( request.getId() );
        post.setTitle( request.getTitle() );
        post.setSeoPath( request.getSeoPath() );
        post.setContent( request.getContent() );
        post.setStatus( request.getStatus() );

        return post;
    }
}
