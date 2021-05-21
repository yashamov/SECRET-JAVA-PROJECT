package lesson6.server;


//import lesson6.server.model.ApiUser;
import lesson6.server.model.User;
//import lesson6.server.repositories.ApiUserRepository;
import lesson6.server.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
