package ua.dou.hack.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  21.02.15.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/*")
    public ModelAndView getHomePage() {
        return new ModelAndView("index");
    }
}
