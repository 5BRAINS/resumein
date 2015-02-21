package ua.dou.hack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.domain.User;
import ua.dou.hack.repository.UserRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.UserService;
import ua.dou.hack.service.common.AbstractService;

/**
 * mocker on 21.02.15 at 18:09.
 */

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Operations<User, Integer> getRepository() {
        return userRepository;
    }
}
