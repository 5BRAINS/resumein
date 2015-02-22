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
import ua.dou.hack.repository.UserRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.ResumeService;
import ua.dou.hack.service.common.AbstractService;
import ua.dou.hack.utils.PdfUtils;
import ua.dou.hack.utils.ResponseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

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
    private UserRepository userRepository;

    @Autowired
    private PdfUtils pdfUtils;
    
    @Override
    protected Operations<Resume, Integer> getRepository() {
        return resumeRepository;
    }

    @Override
    public String getUserInfo(String accessToken) {
        User user = userRepository.findByToken(accessToken);
        if (user == null)
            return "";
        if (!user.getResumes().isEmpty())
            return user.getResumes().get(0).getUserInfo();
        return grabUserInfo(accessToken);
    }

    @Override
    public void savePdf(String accessToken, String html) {
        User user = userRepository.findByToken(accessToken);
        if (user == null)
            return;
        String path = "3.html";
        try {
            FileWriter out = new FileWriter(path);
            out.write(html);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdfUtils.createPdf(path, "/home/troshchuk/qwe.pdf");
        if (!user.getResumes().isEmpty()) {
            user.getResumes().get(0).setPath("/home/troshchuk/" + user.getId());

        } else {
            Resume resume = new Resume();
            resume.setPath("files/" + user.getId());
            user.getResumes().add(resume);
        }
        userRepository.update(user);
    }

    @Override
    public void saveResume(String accessToken, String resumeInfo, String resumeName,
                           int templateId) {
        User user = userRepository.findByToken(accessToken);
        if (user == null)
            return;
        if (!user.getResumes().isEmpty()) {
            user.getResumes().get(0).setUserInfo(resumeInfo);
            userRepository.update(user);
            return;
        }
        Resume resume = new Resume();
        resume.setUser(user);
        resume.setName(resumeName);
        resume.setTemplateId(templateId);

        create(resume);
    }

    @Override
    public void saveLink(String accessToken, String link) {
        User user = userRepository.findByToken(accessToken);
        if (user == null)
            return;
        if (user.getResumes().isEmpty())
            return;
        user.getResumes().get(0).setLink(link);
        userRepository.update(user);
    }

    @Override
    public boolean isResumeInUser(String accessToken) {
        User user = userRepository.findByToken(accessToken);
        return user != null && !user.getResumes().isEmpty();
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
