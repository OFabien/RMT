/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.JPA;

import com.supinfo.DAO.UserDAO;
import com.supinfo.Entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabien
 */
@Stateless
public class JpaUserDAO implements UserDAO{
    @PersistenceContext
    private EntityManager myEntityManager;
    private EntityTransaction myEntityTransaction;

    @Override
    public User findById(Long _id) {
        try
            {
                    return myEntityManager.find(User.class, _id);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
            return null;
        }

    @Override
    public Integer add(User addUser) {
        Integer error = 0;
        try {
            myEntityManager.persist(addUser);
            myEntityManager.flush();
        } catch (Exception e) {
            error =  1;
            e.printStackTrace();
        }
        return error;
    }

    @Override
    public User findByEmail(String _email) {
        try {
                return (User) myEntityManager.createQuery("SELECT u FROM User u WHERE u.email='" + _email + "'").getSingleResult();
        }
        catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }
}
