package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class HomeController {
    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DateRepository dateRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/")
    public String showIndex(Model model) {
        return "mainPage";
    }

    @RequestMapping("/history")
    public String searchHistory(Model model, Authentication authentication) {
        AppUser user = appUserRepository.findAppUserByUsername(authentication.getName());
        model.addAttribute("users", dateRepository.findAllByDateUser(user));
        return "searchHistory";
    }

    @GetMapping("/getdate")
    public String addItem(Model model) {
        AppDate appDate = new AppDate();
        dateRepository.save(appDate);
        model.addAttribute("dates", appDate);
        return "getDate";
    }

    @PostMapping("/processdate")
    public String processDate(@Valid @ModelAttribute("date") AppDate appDate, BindingResult result, Model model, Authentication authentication) {
        if (result.hasErrors()) {
            return "getDate";
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(appDate.getInputDate());
            appDate.setmName(c.get(Calendar.DAY_OF_WEEK));
            appDate.setfName(c.get(Calendar.DAY_OF_WEEK));
            appDate.setZodiac(c.get(Calendar.YEAR) % 12);
            appDate.addUser(appUserRepository.findAppUserByUsername(authentication.getName()));
            dateRepository.save(appDate);
            model.addAttribute("date", appDate);
            return "output";

        }
    }
}

