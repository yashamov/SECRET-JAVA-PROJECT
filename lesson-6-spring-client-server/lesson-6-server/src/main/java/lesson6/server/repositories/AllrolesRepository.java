package lesson6.server.repositories;

        import lesson6.server.model.Admin;
        import lesson6.server.model.Allroles;
        import lesson6.server.model.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

public interface AllrolesRepository extends JpaRepository<Allroles, Long> {
        @Query("SELECT con FROM Allroles con  WHERE con.login=(:login)")
        Allroles findByUserlogin(@Param("login") String login);
}
