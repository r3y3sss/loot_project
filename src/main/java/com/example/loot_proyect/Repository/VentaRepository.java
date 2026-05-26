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

    public void actualizarVenta(VentaEntity venta) {
        EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            VentaEntity ventaActual = em.find(VentaEntity.class, venta);
            if (ventaActual != null) {
                // actualiza los campos que necesites
                em.merge(venta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void eliminarVenta(VentaEntity venta) {
        EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            VentaEntity eliminar = em.merge(venta);
            em.remove(eliminar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
