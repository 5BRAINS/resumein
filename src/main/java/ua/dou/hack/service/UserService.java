package ua.dou.hack.service;

import ua.dou.hack.domain.User;
import ua.dou.hack.repository.common.Operations;

import javax.servlet.http.HttpServletResponse;

/**
 * mocker on 21.02.15 at 18:08.
 */
public interface UserService extends Operations<User, Integer> {
    void saveAccessToken(String code, HttpServletResponse response);

    void createUser(String accessToken, int expIn);

    boolean isTokenOld(String accessToken);

    String getShortLink(String accessToken);
}
