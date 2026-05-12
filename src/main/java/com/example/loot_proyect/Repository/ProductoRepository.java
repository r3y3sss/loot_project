package com.example.loot_proyect.Repository;

import com.example.loot_proyect.model.ProductoEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ProductoRepository {


    public void AgregarProducto(ProductoEntity Producto) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(Producto);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
    public void EliminarProducto(ProductoEntity Producto) {
        EntityManager entityManager= HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(Producto));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void ActualizarProducto(ProductoEntity Producto) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(Producto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<ProductoEntity> buscarProductos() {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<ProductoEntity> lista=entityManager.createQuery("from ProductoEntity").getResultList();
        entityManager.close();
        return lista;
    }
    public ProductoEntity buscarIdProducto(int idProducto) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProductoEntity productoEntity = entityManager.find(ProductoEntity.class, idProducto);
        entityManager.close();
        return productoEntity;
    }
}

