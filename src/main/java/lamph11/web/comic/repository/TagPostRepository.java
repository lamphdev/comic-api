package lamph11.web.comic.repository;

import lamph11.web.comic.entity.TagPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagPostRepository extends JpaRepository<TagPost, Long> {

    @Modifying
    @Query("delete from TagPost tp where tp.post.id = ?1")
    void deleteAllByPost(Long postID);
}
