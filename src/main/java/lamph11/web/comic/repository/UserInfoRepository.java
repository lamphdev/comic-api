package lamph11.web.comic.repository;

import lamph11.web.comic.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>,
        JpaSpecificationExecutor<UserInfo> {

    @Query("select u from UserInfo u where u.email like ?1")
    Optional<UserInfo> findByUsername(String username);
}
