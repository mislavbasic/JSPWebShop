package com.mbasic.dal.service.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModelServiceImpl implements ModelService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public boolean add(Object o) {
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}
