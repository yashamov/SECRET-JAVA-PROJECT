package Repositories;

import DataBase.DBConnectionManager;

import Entities.Users;

import java.sql.*;

public class UsersRepository {


    private final DBConnectionManager dbConnectionManager;

    public UsersRepository(){
        this.dbConnectionManager = new DBConnectionManager();
    }

    public Users getUsersByCode(String code){
        Users user = null;
        try (Connection conn = this.dbConnectionManager.connect();
             PreparedStatement st = conn.prepareStatement("select * from users where users_code = ?")){

            st.setString(1, code);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                user = new Users(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10)
                        );
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void addUser(Users user){
        try {
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, user.getUsers_code());
            st.setString(2, user.getUsers_name());
            st.setString(3, user.getUsers_surname());
            st.setString(4, user.getUsers_login());
            st.setString(5, user.getUsers_password());
            st.setString(6, user.getUsers_link());
            st.setInt(7, user.getUsers_balance());
            st.setInt(8, user.getUsers_percentOfLose());
            st.setInt(9, user.getUsers_percentOfLose());
            st.setString(10, user.getUsers_phone_no());
            st.executeUpdate();
            st.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteUsersByCode(String code){
        try{
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("delete from users where users_code = ?");
            st.setString(1, code);
            st.execute();
            st.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
