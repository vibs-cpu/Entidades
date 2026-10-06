/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entidades.dao;

/**
 *
 * @author victo
 */
import com.mycompany.entidades.JPAUtil;
import com.mycompany.entidades.modelo.Domicilio;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DomicilioDAO {

    public void registrar(Domicilio domicilio) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(domicilio);

            em.getTransaction().commit();

            System.out.println("Domicilio registrado correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al registrar domicilio.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void consultar() {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            List<Domicilio> domicilios =
                    em.createQuery(
                            "SELECT d FROM Domicilio d",
                            Domicilio.class
                    ).getResultList();

            System.out.println("\n--- LISTA DE DOMICILIOS ---");

            for (Domicilio domicilio : domicilios) {
                System.out.println(domicilio);
            }

        } catch (Exception e) {

            System.out.println("Error al consultar domicilios.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void actualizar(Domicilio domicilio) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(domicilio);

            em.getTransaction().commit();

            System.out.println("Domicilio actualizado correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al actualizar domicilio.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void eliminar(int idDomicilio) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            Domicilio domicilio =
                    em.find(Domicilio.class, idDomicilio);

            if (domicilio != null) {

                em.remove(domicilio);

                System.out.println("Domicilio eliminado correctamente.");

            } else {

                System.out.println("No se encontró el domicilio.");

            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al eliminar domicilio.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }
    public java.util.List<Domicilio> consultarWeb() {

    EntityManager em = JPAUtil.getEntityManager();

    try {

        return em.createQuery(
                "SELECT d FROM Domicilio d",
                Domicilio.class
        ).getResultList();

    } finally {

        em.close();
    }
}
}
