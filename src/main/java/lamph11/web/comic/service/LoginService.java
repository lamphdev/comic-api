package lamph11.web.comic.service;

import lamph11.web.comic.common.TokenUtils;
import lamph11.web.comic.dto.request.LoginRequest;
import lamph11.web.comic.dto.request.RefreshTokenRequest;
import lamph11.web.comic.dto.response.LoginResponse;
import lamph11.web.comic.entity.Role;
import lamph11.web.comic.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class LoginService {

    private final TokenUtils tokenUtils;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    /**
     * login with username and password
     *
     * @param request request payload
     * @return
     */
    public LoginResponse loginWithAccount(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Optional<UserInfo> userInfoOptional = userService.getUserByUsername(username);
        if (userInfoOptional.isEmpty())
            throw new BadCredentialsException("Username not found");

        UserInfo userInfo = userInfoOptional.get();
        if (!passwordEncoder.matches(password, userInfo.getHashPassword())) {
            throw new BadCredentialsException("Password is invalid");
        }

        List<Role> roles = roleService.getRolesByUserID(userInfo.getId());

        return createLoginResponse(userInfo, roles);
    }

    /**
     * refresh token
     *
     * @return
     */
    public LoginResponse refreshToken(RefreshTokenRequest request) throws Exception {
        String refreshToken = request.getRefreshToken();
        String username = tokenUtils.readToken(refreshToken);
        Optional<UserInfo> userInfoOptional = userService.getUserByUsername(username);
        if (userInfoOptional.isEmpty())
            throw new Exception("Username not exists");

        UserInfo userInfo = userInfoOptional.get();
        List<Role> roles = roleService.getRolesByUserID(userInfo.getId());
        return createLoginResponse(userInfo, roles);
    }

    /**
     * generate token for response
     *
     * @param userInfo
     * @return
     */
    private LoginResponse createLoginResponse(UserInfo userInfo, List<Role> roles) {
        String[] rolesString = roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList())
                .toArray(new String[]{});

        Map<String, Object> data = new HashMap<>();
        data.put("roles", rolesString);

        Instant now = Instant.now();
        String accessToken = tokenUtils.generateToken(userInfo.getEmail(), data, now, 2 * 60L);
        String refreshToken = tokenUtils.generateToken(userInfo.getEmail(), data, now, 7 * 24 * 60 * 60L);
        return new LoginResponse(accessToken, refreshToken);
    }

}
