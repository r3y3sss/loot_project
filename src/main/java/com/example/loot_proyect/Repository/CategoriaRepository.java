package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.CategoriaEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class CategoriaRepository {
    public void agregarCategoria(CategoriaEntity categoria){
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
