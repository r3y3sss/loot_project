package com.example.loot_proyect.utils.Repository;

import com.example.loot_proyect.model.DireccionEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


import java.util.List;

public class DireccionRepository {

    public List<DireccionEntity> buscarDirecciones(int idDireccion) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<DireccionEntity> direcciones = entityManager.createQuery("from DireccionEntity").getResultList();
        entityManager.close();
        return direcciones;
    }
    public void agregarDireccion(DireccionEntity direccion) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(direccion);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void actualizarDireccion(DireccionEntity direccion) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(direccion);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void eliminarDireccion(DireccionEntity direccion) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(direccion);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
