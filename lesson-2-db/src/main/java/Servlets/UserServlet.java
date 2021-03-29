package Servlets;


import Entities.Users;
import Repositories.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private final UsersRepository usersRepository;

    public UserServlet(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("users_code");
        Users user = usersRepository.getUsersByCode(code);
        if (user != null){
            resp.getWriter().println(user);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().println("Entities.Customer not found");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        resp.setContentType("text/html;charset=utf-8");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("users_code");
        String name = req.getParameter("users_name");
        String surname = req.getParameter("users_surname");
        String login = req.getParameter("users_login");
        String password = req.getParameter("users_password");
        String link = req.getParameter("users_link");
        Integer balance = Integer.valueOf(req.getParameter("balance"));
        Integer percentOfProfit = Integer.valueOf(req.getParameter("percentOfProfit"));
        Integer percentOfLose = Integer.valueOf(req.getParameter("percentOfLose"));
        String phone_no = req.getParameter("users_phone_no");

        Users users = new Users(code, name, surname, login, password, link, balance, percentOfProfit, percentOfLose, phone_no);
        usersRepository.addUser(users);
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("users_code");
        usersRepository.deleteUsersByCode(code);
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
