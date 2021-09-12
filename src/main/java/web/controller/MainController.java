package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


//    @Autowired
//    private UserService userService;
    private List<User> users = new ArrayList<>();

    //public MainController(UserService userService) {
        //this.userService = userService;
    //}

    @GetMapping()
    public String getMain(Model model){
        model.addAttribute("users", userService.showAllUsers());
        return "main/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.showUser(id));
        return "main/showUser";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "main/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.createUser(user);
        System.out.println(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(Model model, @PathVariable("id") Integer id){
        model.addAttribute("user", userService.showUser(id));
        return "main/editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Integer id){
        userService.updateUser(user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/";
    }


}
