package ua.dou.hack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "get_short_url")
    @ResponseBody
    public String getShortUrl(@CookieValue("access_token") String accessToken) {

        return "{\"link\" : \"" + userService.getShortLink(accessToken) + "\"}";
    }
}
