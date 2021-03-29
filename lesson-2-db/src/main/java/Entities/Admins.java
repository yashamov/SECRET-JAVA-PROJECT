package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Admins {
    private String admins_code;
    private String admins_name;
    private String admins_surname;
    private String link;
    private String position;
    private String phone_no;

    public Admins() {
    }

    public Admins(String admins_code) {
        this.admins_code = admins_code;
    }

    public String getAdmins_code() {
        return admins_code;
    }

    public void setAdmins_code(String admins_code) {
        this.admins_code = admins_code;
    }

    public String getAdmins_name() {
        return admins_name;
    }

    public void setAdmins_name(String agent_name) {
        this.admins_name = agent_name;
    }



    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAdmins_surname() {
        return admins_surname;
    }

    public void setAdmins_surname(String admins_surname) {
        this.admins_surname = admins_surname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agent_code='" + admins_code + '\'' +
                ", agent_name='" + admins_name + '\'' +
                ", link='" + link + '\'' +
                ", position=" + position +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }

}
