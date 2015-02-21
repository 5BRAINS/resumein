package ua.dou.hack.service;

import ua.dou.hack.domain.User;
import ua.dou.hack.repository.common.Operations;

import javax.servlet.http.HttpServletResponse;

/**
 * mocker on 21.02.15 at 18:08.
 */
public interface UserService extends Operations<User, Integer> {
    void saveAccessToken(String code, HttpServletResponse response);

    int getUserId(String accessToken);

    void createUser(int userId, String accessToken, int expiresIn);

    boolean isTokenOld(String accessToken);
}
