
package lesson6.server.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lesson6.server.model.Admin;
import lesson6.server.model.User;
import lesson6.server.repositories.AdminRepository;
import lesson6.server.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api("admin controller")
public class AdminController {
    final
    AdminRepository adminRepository;
    UserRepository userRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admins")
    @ApiOperation("get all admins")
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok(adminRepository.findAll());
    }

    @GetMapping("/admins/{id}")
    @ApiOperation("get admin by id")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {

        return adminRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @RequestMapping("/admins/login_in")
    @ApiOperation("create a admin")
    public ResponseEntity <List<Admin>> addUser(@RequestParam("name") String name, @RequestParam("password_hash") String password_hash) {
        Admin new_user=new Admin();
        new_user.name=name;
        new_user.password_hash=password_hash;
        ResponseEntity.ok(adminRepository.save(new_user));
        return  ResponseEntity.ok(adminRepository.findAll());

    }

}
