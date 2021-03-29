import Repositories.AdminsRepository;
import Repositories.UsersRepository;
import Servlets.AdminServlet;
import Servlets.UserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

public class Application {

    public static void main(String[] args) {
        HttpServlet userServlet = new UserServlet(new UsersRepository());
        HttpServlet adminServlet = new AdminServlet(new AdminsRepository());


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(userServlet), "/customer");
        context.addServlet(new ServletHolder(adminServlet), "/agent");


        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
