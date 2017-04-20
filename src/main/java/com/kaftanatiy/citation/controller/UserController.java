package com.kaftanatiy.citation.controller;

import com.kaftanatiy.citation.entity.User;
import com.kaftanatiy.citation.repository.UserDataRepository;
import com.kaftanatiy.citation.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller that handle request for user entity
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserDataRepository repository;

    @Autowired
    public UserController(UserDataRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        model.addAttribute("users", repository.findAll());
        return "user/userList";
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public String getAddForm() {
        return "user/addForm";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUser(@PathVariable String username, Model model) {
        model.addAttribute("user", repository.findByUsername(username));
        return "user/user";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return "user/addForm";
        }
        repository.save(user);
        return "redirect:/users/" + user.getUsername();
    }
}
