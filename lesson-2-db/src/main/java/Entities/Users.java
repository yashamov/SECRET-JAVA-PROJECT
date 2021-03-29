package Entities;

import org.mindrot.jbcrypt.BCrypt;

public class Users {
    private String users_code;
    private String users_name;
    private String users_surname;
    private String users_login;
    private String users_password;
    private String users_link;
    private Integer users_balance;
    private Integer users_percentOfProfit;
    private Integer users_percentOfLose;
    private String users_phone_no;

    public Users(String users_code, String firstName, String lastName, String login, String password, String link, int balance, int percentOfProfit, int percentOfLose, String phone_no) {
        this.users_code = users_code;
        this.users_name = firstName;
        this.users_surname = lastName;
        this.users_login = login;
        this.users_password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.users_link = link;
        this.users_balance = balance;
        this.users_percentOfProfit = percentOfProfit;
        this.users_percentOfLose = percentOfLose;
        this.users_phone_no = phone_no;

    }



    public String getUsers_name() {
        return users_name;
    }

    public String getUsers_login() {
        return users_login;
    }

    public String getUsers_password() {
        return users_password;
    }

    public String getUsers_surname() {
        return users_surname;
    }

    public Integer getUsers_balance() {
        return users_balance;
    }
    public String getUsers_link(){
        return users_link;
    }

    public Integer getUsers_percentOfProfit() {
        return users_percentOfLose;
    }

    public Integer getUsers_percentOfLose() {
        return users_percentOfProfit;
    }

    public String getLink() {
        return users_link;
    }

    public String getUsers_phone_no() {
        return users_phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.users_phone_no = phone_no;
    }



    public String getUsers_code() {
        return users_code;
    }

    public void setAgent_code(String agent_code) {
        this.users_code = users_code;
    }


    @Override
    public String toString() {
        return "Entities.User{" +
                "users_code='" + users_code + '\'' +
                ", users_name='" + users_name + '\'' +
                ", balance='" + users_balance + '\'' +
                ", link='" + users_link + '\'' +
                '}';
    }
}
