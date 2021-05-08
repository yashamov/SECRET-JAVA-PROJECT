package lesson6.server.controllers;


import lesson6.server.model.Admin;
import lesson6.server.model.User;
import lesson6.server.repositories.AdminRepository;
import lesson6.server.repositories.UserRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/users/hello")
    public String users() {
        return "<h2> hello, user </h2>";
    }
    /*@GetMapping("/home")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Map<String,Object> model) {
        model.put("name",name);
        return "home";
    }*/
    @GetMapping("/hello")
    public String hello() {


        return "hello";
    }
    @GetMapping("/admin_page")
    public String admin_page() {
        return "admin_page";
    }
    @GetMapping("/admins/hello")
    public String admin() {
        return "<h2> hello, admin </h2>";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String doregistration (@RequestParam String name, @RequestParam String password, @RequestParam String link, @RequestParam  String login, @RequestParam String percent_of_profit, @RequestParam String surname) {
        User new_user=new User();
        new_user.id=1L;
        new_user.name=name;
        new_user.password=password;
        new_user.link=link;
        new_user.login=login;
        new_user.percentOfProfit=percent_of_profit;
        new_user.surname=surname;
        System.out.println(new_user);
        ResponseEntity.ok(userRepository.save(new_user));
        return "registration";
    }
    @GetMapping("/registration_new_admin")
    public String registration_new_admin() {
        return "registration_new_admin";
    }
    @PostMapping("/registration_new_admin")
    public String doregistration_new_admin (@RequestParam String name, @RequestParam String password, @RequestParam String link, @RequestParam  String login, @RequestParam String position, @RequestParam String surname) {
        Admin new_admin=new Admin();
        new_admin.name=name;
        new_admin.password_hash=password;
        new_admin.link=link;
        new_admin.login=login;
        new_admin.position=position;
        new_admin.surname=surname;
        System.out.println(new_admin);
        System.out.println(new_admin);
        ResponseEntity.ok(adminRepository.save(new_admin));
        return "registration_new_admin";
    }



}
