package com.mbasic.dal.service.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

//Adds and deletes any object to/from database
public class ModelServiceImpl implements ModelService {

    private static final Logger LOGGER = Logger.getLogger(ModelServiceImpl.class.getName());
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
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return false;
    }

    @Override
    public boolean delete(Object o) {
        //TODO: logika
        return false;
    }
}
