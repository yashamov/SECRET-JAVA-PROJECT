/*package lesson6.server;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lesson6.server.controllers.AdminController;
import lesson6.server.controllers.GreetingController;
import lesson6.server.model.Account;
import lesson6.server.model.Admin;
import lesson6.server.model.Allroles;
import lesson6.server.model.User;
import lesson6.server.repositories.AccountRepository;
import lesson6.server.repositories.AdminRepository;
import lesson6.server.repositories.AllrolesRepository;
import lesson6.server.repositories.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class UserRepoTest {
    private static final User USER_TO_TEST = new User(1L, "name","surname", "login", "password","USER", "vk.com", 5L, 5L, 5000L);
    private static final Admin ADMIN_TO_TEST = new Admin(2L, "name","surname", "login1", "password","ADMIN", "vk.com", "Founder");
    private static final Admin ADMIN_TO_TEST2 = new Admin(10L, "name","surname", "login2", "password","ADMIN", "vk.com", "Founder");
    private static final Allroles ALLROLES_TO_TEST = new Allroles("USER", "login", "password", 5L);
    private static final Allroles ALLROLES_TO_TEST1 = new Allroles("ADMIN", "login", "password", 10L);
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AllrolesRepository allrolesRepository;


    @Test
    @DisplayName("Тест")
    @Order(0)
    void test_save_find(){

        Assertions.assertEquals(USER_TO_TEST.getLogin(), userRepository.save(USER_TO_TEST).getLogin());
        Admin savedAdmin = adminRepository.save(ADMIN_TO_TEST);
        Assertions.assertEquals(ADMIN_TO_TEST.getLogin(), savedAdmin.getLogin());

        Assertions.assertEquals(USER_TO_TEST.getLogin(), ALLROLES_TO_TEST.getLogin());
        Assertions.assertEquals(USER_TO_TEST.getLogin(), ALLROLES_TO_TEST1.getLogin());



        AdminController adminController = new AdminController(adminRepository);
        GreetingController greetingController = new GreetingController();

        Allroles savedAdminRoles = allrolesRepository.save(ALLROLES_TO_TEST);


        Assertions.assertEquals(adminController.getAdmins(), ResponseEntity.ok(adminRepository.findAll()));

        Assertions.assertEquals(adminController.getAdminById(2L), adminRepository.findById(2L).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()));

        Assertions.assertNotEquals(adminController.getAdminById(2L), adminRepository.findById(5L).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()));

        Assertions.assertEquals(USER_TO_TEST.getId(), userRepository.findByUserlogin(USER_TO_TEST.login).getId());

        Assertions.assertEquals(greetingController.users(), "<h2> hello, user </h2>");

        Assertions.assertEquals(greetingController.redirect(), "redirect:/home");

        //Assertions.assertEquals(greetingController.user_page("name", Model model));

       // Assertions.assertEquals(greetingController.hello(), "hello");

        Assertions.assertEquals(greetingController.top_up_balance(), "top_up_balance");

       // Assertions.assertEquals(greetingController.admin_page(), "admin_page");

        Assertions.assertEquals(greetingController.admin(), "<h2> hello, admin </h2>");

        Assertions.assertEquals(greetingController.registration(), "registration");

        Assertions.assertEquals(greetingController.find_user("name"), "redirect:/user_by_name/1");

        Assertions.assertEquals(greetingController.user_by_name(), "find_user");

        Assertions.assertEquals(greetingController.add_news(), "add_news");

        Assertions.assertEquals(greetingController.registration_new_admin(), "registration_new_admin");

        //Assertions.assertEquals(greetingController.doregistration("name", "pass", "vk.com", "login", 5L, "surname"), "redirect:/login");



    }

}



*/