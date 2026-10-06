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
import com.mycompany.entidades.modelo.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;


public class UsuarioDAO {

    public void registrar(Usuario usuario) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(usuario);

            em.getTransaction().commit();

            System.out.println("Usuario registrado correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al registrar usuario.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void consultar() {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            List<Usuario> usuarios =
                    em.createQuery(
                            "SELECT u FROM Usuario u",
                            Usuario.class
                    ).getResultList();

            System.out.println("\n--- LISTA DE USUARIOS ---");

            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

        } catch (Exception e) {

            System.out.println("Error al consultar usuarios.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void actualizar(Usuario usuario) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(usuario);

            em.getTransaction().commit();

            System.out.println("Usuario actualizado correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al actualizar usuario.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }

    public void eliminar(int idUsuario) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            Usuario usuario =
                    em.find(Usuario.class, idUsuario);

            if (usuario != null) {

                em.remove(usuario);

                System.out.println("Usuario eliminado correctamente.");

            } else {

                System.out.println("No se encontró el usuario.");

            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al eliminar usuario.");
            System.out.println(e.getMessage());

        } finally {

            em.close();
        }
    }
    public java.util.List<Usuario> consultarWeb() {

    EntityManager em = JPAUtil.getEntityManager();

    try {

        return em.createQuery(
                "SELECT u FROM Usuario u",
                Usuario.class
        ).getResultList();

    } finally {

        em.close();
    }
}
}