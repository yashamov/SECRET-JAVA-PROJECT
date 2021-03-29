package Servlets;


import Entities.Admins;
import Repositories.AdminsRepository;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private final AdminsRepository adminsRepository;

    public AdminServlet(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("admins_code");

        Admins admin = adminsRepository.getAdminByCode(code);
        if (admin != null){
            resp.getWriter().println(admin);
        } else {
            resp.getWriter().println("Entities.Admin not found");
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }


}
