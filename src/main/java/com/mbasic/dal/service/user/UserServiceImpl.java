package com.mbasic.dal.service.user;

import com.mbasic.dal.model.LoginLog;
import com.mbasic.dal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Returns User object/s from database
//Handles login requests
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public User login(String email, String password) {
        User user;
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Query login = em.createNativeQuery("SELECT * FROM Users WHERE Email = '" + email + "' AND Password = '" + password + "'", User.class);
            user = (User)login.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return user;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        //TODO: logika
        return null;
    }

    @Override
    public List<LoginLog> findAllLog() {
        List<LoginLog> loginLogList;
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Query getLog = em.createNativeQuery("SELECT * FROM Login", LoginLog.class);
            loginLogList = getLog.getResultList();
            em.getTransaction().commit();
            em.close();
            return loginLogList;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }
}
