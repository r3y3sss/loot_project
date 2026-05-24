package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioRepository {

    public void agregarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error al agregar usuario: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void actualizarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public UsuarioEntity buscarCorreo(String correo) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.createQuery(
                            "SELECT u FROM UsuarioEntity u WHERE u.correo = :correo", UsuarioEntity.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    public UsuarioEntity buscarUsuario(int id) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(UsuarioEntity.class, id);
        } catch (Exception e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<UsuarioEntity> getAllUsuarios() {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.createQuery(
                            "SELECT u FROM UsuarioEntity u", UsuarioEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }
}