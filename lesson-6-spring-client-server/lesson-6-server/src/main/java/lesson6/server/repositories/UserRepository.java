package lesson6.server.repositories;

import lesson6.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT con FROM User con  WHERE con.login=(:login)")
    User findByUserlogin(@Param("login") String login);


}
