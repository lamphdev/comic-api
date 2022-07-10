package lamph11.web.comic.service;

import lamph11.web.comic.dto.TagDTO;
import lamph11.web.comic.entity.Tag;
import lamph11.web.comic.exception.ServiceException;
import lamph11.web.comic.exception.ValidateException;
import lamph11.web.comic.mapper.TagMapper;
import lamph11.web.comic.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;

    /**
     * create new tag
     *
     * @param tagDTO
     * @return
     */
    public TagDTO createTag(TagDTO tagDTO) {
        Tag tagEntity = tagMapper.toEntity(tagDTO);
        tagRepository.save(tagEntity);
        return tagMapper.toDTO(tagEntity);
    }

    /**
     * update tag
     *
     * @param tagDTO
     * @return
     * @throws ValidateException
     */
    public TagDTO updateTag(TagDTO tagDTO) throws ValidateException {
        Optional<Tag> tagOptional = tagRepository.findById(tagDTO.getId());
        if (tagOptional.isEmpty())
            throw new ValidateException("Tag not found");

        Tag tagEntity = tagMapper.toEntity(tagDTO);
        tagRepository.save(tagEntity);
        return tagMapper.toDTO(tagEntity);
    }

    /**
     * get list tag by list id
     *
     * @param id list of id
     * @return
     */
    public List<TagDTO> findByID(List<Long> id) {
        return tagMapper.toDTO(tagRepository.findAllById(id));
    }

}
