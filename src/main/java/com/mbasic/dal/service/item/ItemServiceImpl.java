package com.mbasic.dal.service.item;

import com.mbasic.dal.model.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Returns Item object/s from database
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = Logger.getLogger(ItemServiceImpl.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public List<Item> findByCategory(String category) {
        List<Item> itemList;
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //TODO: ne mogu gledat ni ovo
            Query findByCategory = em.createNativeQuery("SELECT * FROM Items WHERE Category = " + category, Item.class);
            itemList = findByCategory.getResultList();
            return itemList;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList;
        EntityManager em;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Query findAll = em.createNativeQuery("SELECT * FROM Items", Item.class);
            itemList = findAll.getResultList();
            return itemList;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }
}
