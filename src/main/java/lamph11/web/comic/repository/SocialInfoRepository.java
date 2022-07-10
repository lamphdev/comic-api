package lamph11.web.comic.repository;

import lamph11.web.comic.entity.SocialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialInfoRepository extends JpaRepository<SocialInfo, Long>,
        JpaSpecificationExecutor<SocialInfo> {
}
