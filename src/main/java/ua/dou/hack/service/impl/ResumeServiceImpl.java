package ua.dou.hack.service.impl;

import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.domain.Resume;
import ua.dou.hack.domain.User;
import ua.dou.hack.repository.ResumeRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.ResumeService;
import ua.dou.hack.service.UserService;
import ua.dou.hack.service.common.AbstractService;
import ua.dou.hack.utils.ResponseUtils;

/**
 * mocker on 22.02.15 at 2:23.
 */
@Service
@Transactional
@PropertySource("classpath:userInfo.properties")
public class ResumeServiceImpl
        extends AbstractService<Resume, Integer>
        implements ResumeService {

    @Autowired
    private Environment env;
    
    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    private UserService userService;
    
    @Override
    protected Operations<Resume, Integer> getRepository() {
        return resumeRepository;
    }

    @Override
    public String getUserInfo(String accessToken) {
        User user = userService.findByToken(accessToken);
        if (user == null)
            return "";
        if (!user.getResumes().isEmpty())
            return user.getResumes().get(0).getUserInfo();
        return grabUserInfo(accessToken);
    }

    private String grabUserInfo(String accessToken) {
        String url = env.getProperty("user.info.link");
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Connection", "Keep-Alive");
        httpGet.addHeader("Authorization", "Bearer " + accessToken);
        String entity = responseUtils.getEntity(httpGet);
        return entity;
    }
}
