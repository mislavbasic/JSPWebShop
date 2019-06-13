package com.mbasic.dal.service.item;

import com.mbasic.dal.model.item.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Returns Item object/s from database
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = Logger.getLogger(ItemServiceImpl.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebShop");

    @Override
    public List<Item> findByCategory(String category) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Item> itemList =
                    em.createNativeQuery("SELECT * FROM Items WHERE Category = " + category, Item.class)
                            .getResultList();
            em.getTransaction().commit();
            return itemList;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (em != null) em.close();
        }
        return null;
    }

    @Override
    public Item findById(int id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Item item = em.find(Item.class, id);
            em.getTransaction().commit();
            return item;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (em != null) em.close();
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Item> itemList =
                    em.createNativeQuery("SELECT * FROM Items", Item.class)
                            .getResultList();
            em.getTransaction().commit();
            return itemList;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (em != null) em.close();
        }
        return null;
    }
}
