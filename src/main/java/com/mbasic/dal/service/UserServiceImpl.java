package com.mbasic.dal.service;

import com.mbasic.dal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserServiceImpl implements UserService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public boolean addUser(User user) {
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        //logika
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        //logika
        return null;
    }
}
