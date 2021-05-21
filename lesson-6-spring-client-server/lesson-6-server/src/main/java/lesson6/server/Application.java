package lesson6.server;


import lesson6.server.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootApplication
public class Application extends SpringApplicationBuilder {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}