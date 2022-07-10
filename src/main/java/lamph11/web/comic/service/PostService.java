package lamph11.web.comic.service;

import lamph11.web.comic.dto.PostDTO;
import lamph11.web.comic.dto.request.CreatePostRequest;
import lamph11.web.comic.dto.request.GetPostRequest;
import lamph11.web.comic.dto.request.UpdatePostRequest;
import lamph11.web.comic.entity.Post;
import lamph11.web.comic.entity.Series;
import lamph11.web.comic.entity.TagPost;
import lamph11.web.comic.exception.ValidateException;
import lamph11.web.comic.mapper.PostMapper;
import lamph11.web.comic.repository.PostRepository;
import lamph11.web.comic.repository.SeriesRepository;
import lamph11.web.comic.repository.TagPostRepository;
import lamph11.web.comic.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService extends QueryService<Post> {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final SeriesRepository seriesRepository;
    private final TagPostRepository tagPostRepository;

    /**
     * create post request
     *
     * @param request request payload
     * @return
     */
    public PostDTO create(CreatePostRequest request) {
        Post post = postMapper.fromRequest(request);

        Series series = Optional.ofNullable(request.getSeriesId())
                .flatMap(seriesRepository::findById)
                .orElse(null);

        post.setSeries(series);
        postRepository.save(post);

        List<Long> listOfTagID = request.getTagIds();
        if (listOfTagID != null && !listOfTagID.isEmpty()) {
            List<TagPost> listTagPost = listOfTagID.stream()
                    .map(tagRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(tag -> new TagPost(tag, post))
                    .collect(Collectors.toList());
            tagPostRepository.saveAll(listTagPost);
        }

        return postMapper.toDTO(post);
    }

    /**
     * update post
     *
     * @param request
     * @return
     */
    public PostDTO update(UpdatePostRequest request) throws ValidateException {
        Optional<Post> optionalPost = postRepository.findById(request.getId());
        if (optionalPost.isEmpty())
            throw new ValidateException("Post not found");


        Post postEntity = postMapper.fromRequest(request);
        postEntity.setCreatedDate(optionalPost.get().getCreatedDate());
        postEntity.setUpdatedDate(Instant.now());
        postRepository.save(postEntity);

        tagPostRepository.deleteAllByPost(request.getId());
        tagPostRepository.flush();
        List<Long> listOfTagID = request.getTagIds();
        if (listOfTagID != null && !listOfTagID.isEmpty()) {
            List<TagPost> listTagPost = listOfTagID.stream()
                    .map(tagRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(tag -> new TagPost(tag, optionalPost.get()))
                    .collect(Collectors.toList());
            tagPostRepository.saveAll(listTagPost);
        }

        return postMapper.toDTO(postEntity);
    }

    public Page<PostDTO> getPage(GetPostRequest request) {
        Specification<Post> specification = Specification.where(null);
        if (request.getCreatedDate() != null) {
        }
        // specification = specification.and(buildRangeSpecification(request.getCreatedDate(), ""));
        return null;
    }

}
