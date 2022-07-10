package lamph11.web.comic.service;

import lamph11.web.comic.config.properties.AdminProperties;
import lamph11.web.comic.dto.UserDTO;
import lamph11.web.comic.entity.Role;
import lamph11.web.comic.entity.UserInfo;
import lamph11.web.comic.mapper.UserMapper;
import lamph11.web.comic.repository.RoleRepository;
import lamph11.web.comic.repository.SocialInfoRepository;
import lamph11.web.comic.repository.UserInfoRepository;
import lamph11.web.comic.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserInfoRepository userInfoRepository;
    private final SocialInfoRepository socialInfoRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final AdminProperties adminProperties;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public Optional<UserInfo> getUserByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    public Optional<UserDTO> getUserDetail(String username) {
        return userInfoRepository.findByUsername(username)
                .map(userMapper::toDTO);
    }

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }

    @PostConstruct
    void initAdmin() {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(adminProperties.getUsername());
        userInfo.setHashPassword(passwordEncoder.encode(adminProperties.getPassword()));
        userInfo.setStatus("ACTIVE");
        userInfo.setCreatedDate(Instant.now());
        userInfoRepository.save(userInfo);
    }

}
