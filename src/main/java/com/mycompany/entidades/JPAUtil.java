/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entidades;

/**
 *
 * @author victo
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
/**se indica la configuración de EntidadesPU que está en persistence.xml */
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("EntidadesPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}