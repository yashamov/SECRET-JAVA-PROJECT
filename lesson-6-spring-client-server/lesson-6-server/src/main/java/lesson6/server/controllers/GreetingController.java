package lesson6.server.controllers;


import lesson6.server.model.*;
import lesson6.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AllrolesRepository allrolesRepository;
    @Autowired
    private Open_positionRepository open_positionRepository;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/users/hello")
    public String users() {
        return "<h2> hello, user </h2>";
    }

    /*@GetMapping("/home")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Map<String,Object> model) {
        model.put("name",name);
        return "home";
    }*/
    @GetMapping("/users_page")
    public String user_page(@RequestParam(name = "name",required = false,defaultValue = "300") String name,Model model) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("name",userRepository.findByUserlogin(auth1.getName()).money);

        return "users_page";
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String hello(@RequestParam(name = "type",required = false,defaultValue = "300") String name,Model model) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();

        if(allrolesRepository.findByUserlogin(auth1.getName()).type.equals("ROLE_USER"))
        {
            model.addAttribute("type","/users_page");

        }
        else
        {model.addAttribute("type","/admin_page");}
        StringBuilder news= new StringBuilder();
        for (int i=0;i<newsRepository.findAll().size();i++)
        {
            news.append(newsRepository.findAll().get(i).text).append(System.lineSeparator());}
        model.addAttribute("news", newsRepository.findAll());
        return "hello";
    }

    @GetMapping("/top_up_balance")
    public String top_up_balance() {

        return "top_up_balance";
    }

    @GetMapping("/change")
    public String change(@RequestParam(name = "stock",required = false,defaultValue = "300") String stock,Model model) {

        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("stock",userRepository.findByUserlogin(auth1.getName()).getPercentOfProfit());
        return "change";
    }
    @PostMapping("/change")
    public String change(@RequestParam Long new_stock) {

        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        User user= userRepository.findByUserlogin(auth1.getName());
        user.percentOfProfit=new_stock;
        userRepository.save(user);

        return "redirect:/change";
    }

    @PostMapping("/top_up_balance")
    public String doregistration(@RequestParam Long money,@RequestParam String number) {

        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();

        userRepository.findByUserlogin(auth1.getName()).money+=money;

       userRepository.save(userRepository.findByUserlogin(auth1.getName()));
        return "redirect:/top_up_balance";
    }


    @GetMapping("/withdraw_money")
    public String withdraw_money() {

        //Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        //userRepository.findByUserlogin(auth1.getName()).money -=money;

        //userRepository.save(userRepository.findByUserlogin(auth1.getName()));
        return "withdraw_money";
    }
    @PostMapping("/withdraw_money")
    public String popolnenie(@RequestParam Long money,@RequestParam String number) {

        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        userRepository.findByUserlogin(auth1.getName()).money-=money;
        userRepository.save(userRepository.findByUserlogin(auth1.getName()));
        return "redirect:/withdraw_money";
    }


    @GetMapping("/admin_page")
    public String admin_page(@RequestParam(name = "sum",required = false,defaultValue = "300") int summa, Model model) {

        int sum=0;
        int fond_money=0;
        for(int i=0;i<userRepository.findAll().size();i++)
        {sum+=userRepository.findAll().get(i).money;}



        model.addAttribute("all_money",sum);
        model.addAttribute("fond_money",fond_money);


        return "admin_page";
    }

    @GetMapping("/admins/hello")
    public String admin() {
        return "<h2> hello, admin </h2>";
    }
    @GetMapping("/admins/investment")
    public String investment() {
        return "investment";
    }
    @PostMapping("/admins/investment")
    public String investment(@RequestParam String type,@RequestParam String name,@RequestParam Long count,@RequestParam Double price) {
        int sum=0;
        int fond_money=0;
        for(int i=0;i<userRepository.findAll().size();i++)
        {sum+=userRepository.findAll().get(i).money;}
        Double profit=0.0;
        Open_position open_position=new Open_position();
        if(type.equals("BUY"))
        {
        open_position.name=name;
        open_position.count=count;
        open_position.price=price;
        ResponseEntity.ok(open_positionRepository.save(open_position));
        }
        if(type.equals("SOLD"))
        {



            if(open_positionRepository.findByPositionName(name)!=null)
            {
            Open_position open_position1=open_positionRepository.findByPositionName(name);
                for(int i=0;i<userRepository.findAll().size();i++)
                {User user=userRepository.findAll().get(i);
                    sum += user.money;
                    }
            profit+=(open_position1.price-price)*count*(-1);
            for(int i=0;i<userRepository.findAll().size();i++)
                {User user=userRepository.findAll().get(i);
                    user.money+=(user.money/sum)*(user.percentOfProfit)*profit;

                    userRepository.save(user);}

            open_position1.count-=count;

            if(open_position1.count==0.0)
            {

                open_positionRepository.delete(open_positionRepository.findByPositionName(name));
            }

            open_positionRepository.save(open_position1);}
        }



        return "redirect:/admins/investment";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/user_by_name")
    public String find_user(@PathVariable("name") String name) {

        return "redirect:/user_by_name/1";
    }

    @PostMapping("/registration")
    public String doregistration(@RequestParam String name, @RequestParam String password, @RequestParam String link, @RequestParam String login, @RequestParam Long percent_of_profit, @RequestParam String surname) {
        Allroles allroles=allrolesRepository.findByUserlogin(login);

        if(allroles!=null)
        {return "registration";}
        else {



        User new_user = new User();
        Allroles new_allroles=new Allroles();
        new_allroles.login=login;
        new_allroles.password=password;
        new_allroles.type="ROLE_USER";
        new_user.name = name;

        new_user.link = link;
        new_user.login = login;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        new_user.password = passwordEncoder.encode(password);

        new_user.percentOfProfit = percent_of_profit;
        new_user.percentOfLose = Math.round((Math.pow((percent_of_profit/100), 2.25)) * 100);
        new_user.surname = surname;
        new_user.money = 0D;
        new_user.type="ROLE_USER";

        ResponseEntity.ok(allrolesRepository.save(new_allroles));
        ResponseEntity.ok(userRepository.save(new_user));
        return "redirect:/login";}
    }

    @GetMapping("/registration_new_admin")
    public String registration_new_admin() {
        return "registration_new_admin";
    }

    @GetMapping("/admins/add_news")
    public String add_news() {
        return "add_news";
    }
    @PostMapping("/admins/add_news")
    public String add_news(@RequestParam String news) {
        News news1=new News();
        news1.id=1L;
        news1.text=news;
        ResponseEntity.ok(newsRepository.save(news1));
        return "redirect:/admins/add_news";
    }

    @GetMapping("/user_by_name")
    public String user_by_name() {

        return "find_user";
    }



    @PostMapping("/registration_new_admin")
    public String doregistration_new_admin(@RequestParam String name, @RequestParam String password, @RequestParam String link, @RequestParam String login, @RequestParam String position, @RequestParam String surname) {
        Allroles allroles=allrolesRepository.findByUserlogin(login);
        if(allroles!=null)
        {return "registration_new_admin";}
        else
        {Allroles new_allroles=new Allroles();
            new_allroles.login=login;
            new_allroles.password=password;
            new_allroles.type="ROLE_ADMIN";
        Admin new_admin = new Admin();
        new_admin.name = name;
        new_admin.password_hash = password;
        new_admin.link = link;
        new_admin.login = login;
        new_admin.position = position;
        new_admin.surname = surname;
        new_admin.type="ROLE_ADMIN";

        ResponseEntity.ok(allrolesRepository.save(new_allroles));
        ResponseEntity.ok(adminRepository.save(new_admin));
        return "redirect:/login";}
    }

}
