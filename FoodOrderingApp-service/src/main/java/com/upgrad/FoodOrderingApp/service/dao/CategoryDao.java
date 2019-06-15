package com.upgrad.FoodOrderingApp.service.dao;


import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CategoryEntity> getAllCategories(String restaurantUuid){

        try {
            return this.entityManager.createNamedQuery("allCategories", CategoryEntity.class).setParameter("uuid", restaurantUuid).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
