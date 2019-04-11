package com.mbasic.dal.service.user;

import com.mbasic.dal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserServiceImpl implements UserService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public boolean login(String username, String password) {
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //TODO: ne mogu gledat ovo
            Query find = em.createNativeQuery("SELECT * FROM Users WHERE Username = " + username + "AND Password = " + password, User.class);
            if (find.getSingleResult() != null){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        //logika
        return null;
    }
}
