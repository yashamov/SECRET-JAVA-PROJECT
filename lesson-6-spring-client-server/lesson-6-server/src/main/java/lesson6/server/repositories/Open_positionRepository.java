package lesson6.server.repositories;

import lesson6.server.model.Admin;
import lesson6.server.model.Open_position;
import lesson6.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Open_positionRepository extends JpaRepository<Open_position, Long> {
    @Query("SELECT con FROM Open_position con  WHERE con.name=(:name)")
    Open_position findByPositionName(@Param("name") String name);

}
