package com.example.loot_proyect.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtils {
    private static EntityManagerFactory entityManagerFactory = null;

    public HibernateUtils() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver MySQL no encontrado", e);
            }
            entityManagerFactory = Persistence.createEntityManagerFactory("com.example.loot_proyect");
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null)
            entityManagerFactory.close();
    }
}