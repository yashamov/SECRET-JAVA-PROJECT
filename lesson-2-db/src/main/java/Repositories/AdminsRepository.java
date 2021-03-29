package Repositories;

import DataBase.DBConnectionManager;
import DataBase.HibernateManager;
import Entities.Admins;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminsRepository {
    private final HibernateManager db;
    private DBConnectionManager dbConnectionManager;


    public AdminsRepository() {
        this.db = new HibernateManager();
    }

    public Admins getAdminByCode(String code){
        Session session = db.getSession();
        Admins admin = session.get(Admins.class, code);
        session.close();
        return admin;
    }


}
