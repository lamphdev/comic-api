package lamph11.web.comic.repository;

import lamph11.web.comic.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r inner join UserRole ur on r.id = ur.role.id where ur.userInfo.id = ?1")
    List<Role> getRolesByUserID(Long userID);

}
