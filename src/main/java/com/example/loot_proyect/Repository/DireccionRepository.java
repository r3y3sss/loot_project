package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.DireccionEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


import java.util.List;

public class DireccionRepository {

    public void buscarDirecciones(DireccionEntity direccion, int idDireccion) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            DireccionEntity direccionEntity = entityManager.find(DireccionEntity.class, idDireccion);
            entityManager.getTransaction().commit();

        }catch (Exception ex) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();

        }


    }

    public void agregarDireccion(DireccionEntity direccion) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (direccion != null) {
                entityManager.persist(direccion);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }



        public void ActualizarDireccion(DireccionEntity direccion, int idDireccion) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();

        try{
            entityManager.getTransaction().begin();
            DireccionEntity direccionActual = entityManager.find(DireccionEntity.class, idDireccion);

            if(direccionActual != null){
                direccionActual.setCalle(direccion.getCalle());
                direccionActual.setEstado(direccion.getEstado());
                direccionActual.setCp(direccion.getCp());
                direccionActual.setColonia(direccion.getColonia());
                direccionActual.setMunicipio(direccion.getMunicipio());
                entityManager.getTransaction().commit();
            }

        }catch(Exception ex){
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }

        }

    public void eliminarDireccion(DireccionEntity direccion) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            DireccionEntity eliminarDir = entityManager.merge(direccion);
            entityManager.remove(eliminarDir);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
