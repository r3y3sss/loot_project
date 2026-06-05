package com.example.loot_proyect.Repository;

import com.example.loot_proyect.Dtos.HistorialDTO;
import com.example.loot_proyect.Dtos.UsuarioDTO;
import com.example.loot_proyect.controllers.LoginController;
import com.example.loot_proyect.controllers.RegistroProductosController;
import com.example.loot_proyect.model.ProductoEntity;
import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.model.VentaEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VentaRepository {
    public void registroVenta(VentaEntity venta){
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        if (LoginController.usuarioEntity != null) {
            UsuarioEntity usuarioManaged = entityManager.find(
                    UsuarioEntity.class,
                    LoginController.usuarioEntity.getId_usuario()
            );
            venta.setUsuario(usuarioManaged);
        }

        if(RegistroProductosController.productoEntity != null){
            ProductoEntity productoManaged = entityManager.find(
                    ProductoEntity.class,
                    RegistroProductosController.productoEntity.getId_producto()
            );
            venta.setProducto(productoManaged);
            System.out.println("no es null");
        }else{
            System.out.println("es null");
        }
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

    public List<VentaEntity> obtenerVentasPorUsuario(int idUsuario) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();

        try {
            return entityManager.createQuery(
                            "SELECT v FROM VentaEntity v " +
                                    "JOIN FETCH v.producto " +
                                    "WHERE v.usuario.id_usuario = :idUsuario",
                            VentaEntity.class)
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }
    }
