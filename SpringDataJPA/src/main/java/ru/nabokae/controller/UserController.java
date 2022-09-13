package ru.nabokae.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nabokae.entity.User;
import ru.nabokae.service.UserService;
import ru.nabokae.service.UserServiceImpl;


@Controller
@RequestMapping("/users")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String ListPage(Model model) {
        logger.info("Запрошен список пользьзовантелей");
        model.addAttribute("usersAll", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String NewUserForm(Model model) {
        logger.info("Запрошена страница создания нового пользователя");
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/all")
    public String UpdateUser(User user) {
        logger.info("Запрошен обновленный список пользователей ");
        userService.save(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{id}")
    public String EditUserForm(@PathVariable("id") Long id, Model model) {
        logger.info("Запрошена страница редактирования пользователя");
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @DeleteMapping("/{id}")
    public String EditUserForm(@PathVariable("id") Long id) {
        logger.info("Запрошена страница удаления пользователя c id={}", id);
        userService.delete(id);
        return "redirect:/users/all";
    }

}
