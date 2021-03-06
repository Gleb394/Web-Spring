package com.gleb.controller;

import com.gleb.controller.constrain.model.RegisterUserDto;
import com.gleb.model.User;
import com.gleb.serves.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private UserServices userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "user") User user, ModelAndView vm) {
        return userService.getUserByEmail(user.getEmail())
                .map(r -> userService.verifyPassword(r, user))
                .filter(Optional::isPresent)
                .map(r -> {
                    vm.setViewName("home");
                    return vm;
                })
                .orElseGet(() -> {
                    vm.setViewName("login");
                    return vm;
                });
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("register");
        vm.addObject("userDto", RegisterUserDto.empty());
        return vm;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid RegisterUserDto userDto, BindingResult result) {
        ModelAndView vm = new ModelAndView();

        if (result.hasErrors()) {
            vm.setViewName("register");
            vm.addObject("userDto", RegisterUserDto.empty());
            return vm;
        }

        User user = User.of(userDto);
        userService.addUser(user);
        vm.setViewName("home");
        return vm;
    }

    @ModelAttribute
    public RegisterUserDto userDto() {
        return RegisterUserDto.empty();
    }
}
