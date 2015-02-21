package ua.dou.hack.web.rest;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dou.hack.service.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  21.02.15.
 */
@Controller
@RequestMapping(value = "/rest/oauth")
public class OauthRestController {
    @Autowired private UserService userService;

    @RequestMapping(value = "saveToken")
    public String save(@RequestParam String code, @RequestParam String state, HttpServletResponse response) {
        userService.saveAccessToken(code, response);
        return "redirect:/";
    }

}
