package ua.dou.hack.service;

import ua.dou.hack.domain.Resume;
import ua.dou.hack.repository.common.Operations;

/**
 * mocker on 22.02.15 at 2:20.
 */
public interface ResumeService extends Operations<Resume, Integer> {
    String getUserInfo(String accessToken);

    boolean isResumeInUser(String accessToken);
    void savePdf(String accessToken, String html);
}
