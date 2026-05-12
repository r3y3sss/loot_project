package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.VentaEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class VentaRepository {
    public void registroVenta(VentaEntity venta){
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(venta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
