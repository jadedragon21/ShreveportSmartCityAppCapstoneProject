package com.tts.capstone.SmartShreveCity.controller;

import com.tts.capstone.SmartShreveCity.model.User;
import com.tts.capstone.SmartShreveCity.repository.UserRepository;
import com.tts.capstone.SmartShreveCity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthorizationController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    //1st page
    @GetMapping("/")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "/login";
    }
//    @GetMapping("/signup")
//    public String registration(Model model) {
//        User user = new User();
//        model.addAttribute("user",user);
//        return "/registration";
//    }

    @PostMapping("/signup")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        User userExists = userService.findByUsername(user.getUsername());

        System.out.println(user);

        if (userExists != null) {
            bindingResult.rejectValue("username",
                    "error.user",
                    "Username is already taken");
        }
        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success",
                    "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return "/registration";
    }


    @PostMapping(value="/login")
    public String login(){
        return "login";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/user-index";
    }


    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(user);
        userRepository.delete(user);
        return "redirect:/update-user";
    }
//
//    @RequestMapping(value="/login", method= RequestMethod.GET)
//    public String login(){
//        return "index";}

    @PostMapping(value="/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user-index";
        }
}