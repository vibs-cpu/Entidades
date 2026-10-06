/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entidades.dao;

import com.mycompany.entidades.JPAUtil;
import com.mycompany.entidades.modelo.Persona;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author victo
 */
public class PersonaDAO {

    public void registrar(Persona persona) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(persona);

            em.getTransaction().commit();

            System.out.println("Persona registrada correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al registrar persona.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void consultar() {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            List<Persona> personas =
                    em.createQuery(
                            "SELECT p FROM Persona p",
                            Persona.class
                    ).getResultList();

            System.out.println("\n--- LISTA DE PERSONAS ---");

            for (Persona persona : personas) {
                System.out.println(persona);
            }

        } catch (Exception e) {

            System.out.println("Error al consultar personas.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void actualizar(Persona persona) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(persona);

            em.getTransaction().commit();

            System.out.println("Persona actualizada correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al actualizar persona.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void eliminar(int idPersona) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            Persona persona =
                    em.find(Persona.class, idPersona);

            if (persona != null) {

                em.remove(persona);

                System.out.println("Persona eliminada correctamente.");

            } else {

                System.out.println("No se encontró la persona.");

            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al eliminar persona.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }
    public java.util.List<Persona> consultarWeb() {

    EntityManager em = JPAUtil.getEntityManager();

    try {

        return em.createQuery(
                "SELECT p FROM Persona p",
                Persona.class
        ).getResultList();

    } finally {

        em.close();
    }
}
}