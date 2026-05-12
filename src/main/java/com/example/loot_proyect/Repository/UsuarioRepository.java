package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class UsuarioRepository {

    public void agregarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void eliminarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void actualizarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
