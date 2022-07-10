package lamph11.web.comic.service;

import lamph11.web.comic.dto.TagPostDTO;
import lamph11.web.comic.mapper.TagPostMapper;
import lamph11.web.comic.repository.TagPostRepository;
import lamph11.web.comic.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagPostService {

    private final TagPostMapper tagPostMapper;
    private final TagPostRepository tagPostRepository;

    public TagPostDTO save(List<TagPostDTO> listTagPostDTO) {
        return null;
    }

}
