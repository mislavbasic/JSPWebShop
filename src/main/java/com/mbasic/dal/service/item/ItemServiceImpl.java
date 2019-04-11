package com.mbasic.dal.service.item;

import com.mbasic.dal.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {

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
            e.printStackTrace();
        }
        return null;
    }
}
