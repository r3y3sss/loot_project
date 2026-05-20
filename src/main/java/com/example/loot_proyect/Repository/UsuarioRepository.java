package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class UsuarioRepository {

    public void agregarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
        }catch(Exception e) {}
    }
    public void eliminarUsuario(UsuarioEntity usuario) {

        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try{
            usuario = entityManager.find(UsuarioEntity.class, usuario.getId());
            entityManager.getTransaction().commit();

           if (usuario != null) {
               entityManager.remove(usuario);
           }else {
            entityManager.merge(usuario);
           }

        }catch (Exception ex){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void actualizarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();

        }catch(Exception ex){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error al actualizar el usuario "+ex.getMessage());
            ex.printStackTrace();

        }finally{
            if(entityManager != null && entityManager.isOpen()){
                entityManager.close();
            }
        }

    }

    public UsuarioEntity buscarUsuario(UsuarioEntity usuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        UsuarioEntity usuarioEncontrado = null;

        try {
            usuarioEncontrado = entityManager.find(UsuarioEntity.class, usuario.getId());
            if (usuarioEncontrado != null) {
                if(usuarioEncontrado.getDireccionEntity() != null){
                    usuarioEncontrado.getDireccionEntity().hashCode();
                }
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar el usuario"+ex.getMessage());
            ex.printStackTrace();

        }finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return usuarioEncontrado;
    }

}