package lamph11.web.comic.service;

import lamph11.web.comic.entity.Role;
import lamph11.web.comic.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    /**
     *
     * @param userID
     * @return
     */
    public List<Role> getRolesByUserID(Long userID) {
        return roleRepository.getRolesByUserID(userID);
    }

}
