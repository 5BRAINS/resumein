package ua.dou.hack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dou.hack.repository.ResumeRepository;
import ua.dou.hack.service.ResumeService;

/**
 * mocker on 22.02.15 at 7:07.
 */
@Controller
@RequestMapping(value = "rest")
public class ResumeRestController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "has_resume")
    @ResponseBody
    public boolean hasResume(@CookieValue("access_token") String accessToken) {

        return resumeService.isResumeInUser(accessToken);
    }

    @RequestMapping(value = "save_resume", method = RequestMethod.POST)
    @ResponseBody
    public void hasResume(@CookieValue("access_token") String accessToken,
                             @RequestParam("name") String resumeName,
                             @RequestParam("template_id") int templateId,
                             @RequestParam("user_info") String userInfo) {
        resumeService.saveResume(accessToken, userInfo, resumeName, templateId);
    }
}
