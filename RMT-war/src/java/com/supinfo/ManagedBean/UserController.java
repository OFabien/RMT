/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.ManagedBean;

import com.supinfo.Entity.Employee;
import com.supinfo.Entity.Manager;
import com.supinfo.Entity.User;
import com.supinfo.sessionBean.UserSessionBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fabien
 */
@ManagedBean
@RequestScoped
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    
    private String email;
    private String password;
    
    @EJB
    private UserSessionBean usb;
    
    public UserController() {
        
    }
    
    public String authentificate() {
        User userAuthentificate = usb.getUser(email);
        if(userAuthentificate != null && userAuthentificate instanceof Manager) {
            return "manage_home.xhtml";
        } else if (userAuthentificate != null && userAuthentificate instanceof Employee) {
            return "employee_home.xhtml";
        }
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
}
