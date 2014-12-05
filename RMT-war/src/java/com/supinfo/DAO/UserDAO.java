/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.DAO;

import com.supinfo.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author fabien
 */


public interface UserDAO {
    public User findById(Long _id);
    public User findByEmail(String _email);
    public Integer add(User addUser);
}
