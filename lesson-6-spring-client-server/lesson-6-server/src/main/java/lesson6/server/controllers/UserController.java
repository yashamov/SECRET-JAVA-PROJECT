
package lesson6.server.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lesson6.server.model.User;
import lesson6.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("user controller")
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    @ApiOperation("get all users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    @GetMapping("/users/{id}")
    @ApiOperation("get user by id")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/user_by_name/{name}")
    public User find_user(@PathVariable("login") String login) {
        System.out.println(login);
        return userRepository.findByUserlogin(login);
    }

    @RequestMapping ("/users/login_in")
    @ApiOperation("create a user")
    public ResponseEntity <List<User>> addUser(@RequestParam("name") String name,@RequestParam("password_hash") String password_hash) {
        User new_user=new User();
        new_user.name=name;

        ResponseEntity.ok(userRepository.save(new_user));
        return  ResponseEntity.ok(userRepository.findAll());
    }




}
