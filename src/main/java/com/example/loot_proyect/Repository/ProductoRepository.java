package com.example.loot_proyect.Repository;

import com.example.loot_proyect.controllers.LoginController;
import com.example.loot_proyect.model.ProductoEntity;
import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ProductoRepository {


    public void AgregarProducto(ProductoEntity Producto) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        if (LoginController.usuarioEntity != null) {
            UsuarioEntity usuarioManaged = entityManager.find(
                    UsuarioEntity.class,
                    LoginController.usuarioEntity.getId_usuario()
            );
            Producto.setUsuario(usuarioManaged);
        }
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

        List<ProductoEntity> lista = entityManager.createQuery(
                "SELECT p FROM ProductoEntity p LEFT JOIN FETCH p.usuario", ProductoEntity.class
        ).getResultList();

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

