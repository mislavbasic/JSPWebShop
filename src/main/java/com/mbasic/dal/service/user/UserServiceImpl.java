package com.mbasic.dal.service.user;

import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Returns user object/s from database
//Handles login requests
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public User login(String email, String password) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            User user = (User) em.createNativeQuery("SELECT * FROM Users WHERE Email = :email AND Password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (em != null) em.close();
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
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            List<LoginLog> loginLogList =
                    em.createNativeQuery("SELECT * FROM Login", LoginLog.class).getResultList();
            em.getTransaction().commit();
            return loginLogList;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (em != null) em.close();
        }
        return null;
    }
}
