package ua.dou.hack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dou.hack.service.ResumeService;
import ua.dou.hack.service.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  22.02.15.
 */
@Controller
@RequestMapping(value = "rest")
public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "get_short_url")
    @ResponseBody
    public String getShortUrl(@CookieValue("access_token") String accessToken) {

        return userService.getShortLink(accessToken);
    }

    @RequestMapping(value = "get_user_info")
    @ResponseBody
    public String getUserInfo(@CookieValue("access_token") String accessToken) {
        return resumeService.getUserInfo(accessToken);
    }

    @RequestMapping(value = "save_pdf", method = RequestMethod.POST)
    @ResponseBody
    public String savePdf(@CookieValue("access_token") String accessToken, String html) {
        resumeService.savePdf(accessToken, html);
        return "";
    }

    @RequestMapping(value = "has_resume")
    @ResponseBody
    public boolean hasResume(@CookieValue("access_token") String accessToken) {

        return resumeService.isResumeInUser(accessToken);
    }
}
