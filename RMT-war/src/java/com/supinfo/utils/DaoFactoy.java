/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.utils;

import com.supinfo.DAO.UserDAO;
import com.supinfo.JPA.JpaUserDAO;

/**
 *
 * @author fabien
 */
public class DaoFactoy {
    public static UserDAO getUserDAO() {
	return new JpaUserDAO();
    }
}
