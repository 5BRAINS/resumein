package ua.dou.hack.repository;

import ua.dou.hack.domain.User;
import ua.dou.hack.repository.common.GenericRepository;

/**
 * mocker on 21.02.15 at 17:53.
 */
public interface UserRepository extends GenericRepository <User, Integer> {
    User find(int userId);

    User findByToken(String accessToken);
}
