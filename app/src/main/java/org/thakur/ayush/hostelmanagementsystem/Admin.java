package org.thakur.ayush.hostelmanagementsystem;

import java.io.Serializable;
import java.lang.ref.SoftReference;

/**
 * Created by win on 29-10-2018.
 */

public class Admin implements Serializable{
    private String admin_id;
    private String admin_name;
    private String Admin_password;
    private String Admin_email;
    private int Admin_manages;

    public Admin() {
    }

    public Admin(String admin_id, String admin_name, String admin_password, String admin_email, int admin_manages) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        Admin_password = admin_password;
        Admin_email = admin_email;
        Admin_manages = admin_manages;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return Admin_password;
    }

    public void setAdmin_password(String admin_password) {
        Admin_password = admin_password;
    }

    public String getAdmin_email() {
        return Admin_email;
    }

    public void setAdmin_email(String admin_email) {
        Admin_email = admin_email;
    }

    public int getAdmin_manages() {
        return Admin_manages;
    }

    public void setAdmin_manages(int admin_manages) {
        Admin_manages = admin_manages;
    }
}
