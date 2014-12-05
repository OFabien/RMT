/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.sessionBean;

import com.supinfo.DAO.UserDAO;
import com.supinfo.Entity.User;
import com.supinfo.utils.DaoFactoy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author fabien
 */
@Stateless
@LocalBean
public class UserSessionBean {
    
    @EJB
    private UserDAO userDAO;
    
    public User getUser(String _email) {
        return userDAO.findByEmail(_email);
    }
    
    public Integer addUser(User _newUser) {
        return userDAO.add(_newUser);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
