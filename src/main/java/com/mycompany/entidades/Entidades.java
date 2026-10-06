/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.entidades;

import com.mycompany.entidades.dao.DomicilioDAO;
import com.mycompany.entidades.dao.PersonaDAO;
import com.mycompany.entidades.dao.UsuarioDAO;
import com.mycompany.entidades.modelo.Domicilio;
import com.mycompany.entidades.modelo.Persona;
import com.mycompany.entidades.modelo.Usuario;
import jakarta.persistence.EntityManager;
import java.util.Scanner;

public class Entidades {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("====================================");
            System.out.println("       SISTEMA DE ENTIDADES");
            System.out.println("====================================");
            System.out.println("1. Usuarios");
            System.out.println("2. Personas");
            System.out.println("3. Domicilios");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    menuUsuarios(teclado);
                    break;

                case 2:
                    menuPersonas(teclado);
                    break;

                case 3:
                    menuDomicilios(teclado);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 4);

        teclado.close();
    }

    // ====================================
    // MENU DE USUARIOS
    // ====================================

    public static void menuUsuarios(Scanner teclado) {

        int opcion;

        do {
            System.out.println();
            System.out.println("====================================");
            System.out.println("             USUARIOS");
            System.out.println("====================================");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Consultar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Regresar");
            System.out.println("====================================");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    teclado.nextLine();

                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("        REGISTRAR USUARIO");
                    System.out.println("====================================");

                    System.out.print("Ingrese nombre de usuario: ");
                    String nombreUsuario = teclado.nextLine();

                    System.out.print("Ingrese contraseña: ");
                    String contrasena = teclado.nextLine();

                    System.out.print("Ingrese ID de la persona: ");
                    int idPersona = teclado.nextInt();

                    EntityManager emRegistrar = JPAUtil.getEntityManager();

                    try {
                        Persona persona = emRegistrar.find(Persona.class, idPersona);

                        if (persona == null) {
                            System.out.println("No existe una persona con ese ID.");
                        } else {
                            Usuario usuario = new Usuario(
                                    nombreUsuario,
                                    contrasena,
                                    persona
                            );

                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            usuarioDAO.registrar(usuario);
                        }
                    } finally {
                        emRegistrar.close();
                    }

                    break;

                case 2:
                    UsuarioDAO usuarioDAOConsultar = new UsuarioDAO();
                    usuarioDAOConsultar.consultar();
                    break;

                case 3:
                    teclado.nextLine();

                    System.out.print("Ingrese ID del usuario: ");
                    int idUsuario = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Ingrese nuevo nombre de usuario: ");
                    String nuevoNombreUsuario = teclado.nextLine();

                    System.out.print("Ingrese nueva contraseña: ");
                    String nuevaContrasena = teclado.nextLine();

                    System.out.print("Ingrese ID de la persona: ");
                    int nuevoIdPersona = teclado.nextInt();

                    EntityManager emActualizar = JPAUtil.getEntityManager();

                    try {
                        Usuario usuario = emActualizar.find(Usuario.class, idUsuario);
                        Persona persona = emActualizar.find(Persona.class, nuevoIdPersona);

                        if (usuario == null) {
                            System.out.println("No existe un usuario con ese ID.");
                        } else if (persona == null) {
                            System.out.println("No existe una persona con ese ID.");
                        } else {
                            usuario.setNombreUsuario(nuevoNombreUsuario);
                            usuario.setContrasena(nuevaContrasena);
                            usuario.setPersona(persona);

                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            usuarioDAO.actualizar(usuario);
                        }
                    } finally {
                        emActualizar.close();
                    }

                    break;

                case 4:
                    System.out.print("Ingrese ID del usuario a eliminar: ");
                    int idEliminar = teclado.nextInt();

                    UsuarioDAO usuarioDAOEliminar = new UsuarioDAO();
                    usuarioDAOEliminar.eliminar(idEliminar);

                    break;

                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 5);
    }

    // ====================================
    // MENU DE PERSONAS
    // ====================================

    public static void menuPersonas(Scanner teclado) {

        int opcion;

        do {
            System.out.println();
            System.out.println("====================================");
            System.out.println("             PERSONAS");
            System.out.println("====================================");
            System.out.println("1. Registrar persona");
            System.out.println("2. Consultar personas");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Regresar");
            System.out.println("====================================");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    teclado.nextLine();

                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("        REGISTRAR PERSONA");
                    System.out.println("====================================");

                    System.out.print("Ingrese nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese apellido paterno: ");
                    String apellidoPaterno = teclado.nextLine();

                    System.out.print("Ingrese apellido materno: ");
                    String apellidoMaterno = teclado.nextLine();

                    System.out.print("Ingrese telefono: ");
                    String telefono = teclado.nextLine();

                    System.out.print("Ingrese correo: ");
                    String correo = teclado.nextLine();

                    System.out.print("Ingrese ID del domicilio: ");
                    int idDomicilio = teclado.nextInt();

                    EntityManager emRegistrarPersona = JPAUtil.getEntityManager();

                    try {
                        Domicilio domicilio = emRegistrarPersona.find(Domicilio.class, idDomicilio);

                        if (domicilio == null) {
                            System.out.println("No existe un domicilio con ese ID.");
                        } else {
                            Persona persona = new Persona(
                                    nombre,
                                    apellidoPaterno,
                                    apellidoMaterno,
                                    telefono,
                                    correo,
                                    domicilio
                            );

                            PersonaDAO personaDAO = new PersonaDAO();
                            personaDAO.registrar(persona);
                        }
                    } finally {
                        emRegistrarPersona.close();
                    }

                    break;

                case 2:
                    PersonaDAO personaDAOConsultar = new PersonaDAO();
                    personaDAOConsultar.consultar();
                    break;

                case 3:
                    teclado.nextLine();

                    System.out.print("Ingrese ID de la persona: ");
                    int idPersonaActualizar = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Ingrese nuevo apellido paterno: ");
                    String nuevoApellidoPaterno = teclado.nextLine();

                    System.out.print("Ingrese nuevo apellido materno: ");
                    String nuevoApellidoMaterno = teclado.nextLine();

                    System.out.print("Ingrese nuevo telefono: ");
                    String nuevoTelefono = teclado.nextLine();

                    System.out.print("Ingrese nuevo correo: ");
                    String nuevoCorreo = teclado.nextLine();

                    System.out.print("Ingrese ID del domicilio: ");
                    int nuevoIdDomicilio = teclado.nextInt();

                    EntityManager emActualizarPersona = JPAUtil.getEntityManager();

                    try {
                        Persona persona = emActualizarPersona.find(Persona.class, idPersonaActualizar);
                        Domicilio domicilio = emActualizarPersona.find(Domicilio.class, nuevoIdDomicilio);

                        if (persona == null) {
                            System.out.println("No existe una persona con ese ID.");
                        } else if (domicilio == null) {
                            System.out.println("No existe un domicilio con ese ID.");
                        } else {
                            persona.setNombre(nuevoNombre);
                            persona.setApellidoPaterno(nuevoApellidoPaterno);
                            persona.setApellidoMaterno(nuevoApellidoMaterno);
                            persona.setTelefono(nuevoTelefono);
                            persona.setCorreo(nuevoCorreo);
                            persona.setDomicilio(domicilio);

                            PersonaDAO personaDAO = new PersonaDAO();
                            personaDAO.actualizar(persona);
                        }
                    } finally {
                        emActualizarPersona.close();
                    }

                    break;

                case 4:
                    System.out.print("Ingrese ID de la persona a eliminar: ");
                    int idEliminarPersona = teclado.nextInt();

                    PersonaDAO personaDAOEliminar = new PersonaDAO();
                    personaDAOEliminar.eliminar(idEliminarPersona);

                    break;

                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 5);
    }

    // ====================================
    // MENU DE DOMICILIO
    // ====================================

    private static void menuDomicilios(Scanner scanner) {

        DomicilioDAO domicilioDAO = new DomicilioDAO();
        int opcion;

        do {
            System.out.println("\n====================================");
            System.out.println("           DOMICILIOS");
            System.out.println("====================================");
            System.out.println("1. Registrar domicilio");
            System.out.println("2. Consultar domicilios");
            System.out.println("3. Actualizar domicilio");
            System.out.println("4. Eliminar domicilio");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRAR DOMICILIO ---");

                    System.out.print("Calle: ");
                    String calle = scanner.nextLine();

                    System.out.print("Numero: ");
                    String numero = scanner.nextLine();

                    System.out.print("Colonia: ");
                    String colonia = scanner.nextLine();

                    System.out.print("Municipio: ");
                    String municipio = scanner.nextLine();

                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("Codigo postal: ");
                    String codigoPostal = scanner.nextLine();

                    Domicilio domicilio = new Domicilio(
                            calle,
                            numero,
                            colonia,
                            municipio,
                            estado,
                            codigoPostal
                    );

                    domicilioDAO.registrar(domicilio);

                    break;

                case 2:
                    domicilioDAO.consultar();
                    break;

                case 3:
                    System.out.println("\n--- ACTUALIZAR DOMICILIO ---");

                    System.out.print("ID del domicilio: ");
                    int idDomicilio = scanner.nextInt();
                    scanner.nextLine();

                    EntityManager em = JPAUtil.getEntityManager();

                    Domicilio domicilioActualizar = em.find(Domicilio.class, idDomicilio);

                    if (domicilioActualizar != null) {
                        System.out.print("Nueva calle: ");
                        domicilioActualizar.setCalle(scanner.nextLine());

                        System.out.print("Nuevo numero: ");
                        domicilioActualizar.setNumero(scanner.nextLine());

                        System.out.print("Nueva colonia: ");
                        domicilioActualizar.setColonia(scanner.nextLine());

                        System.out.print("Nuevo municipio: ");
                        domicilioActualizar.setMunicipio(scanner.nextLine());

                        System.out.print("Nuevo estado: ");
                        domicilioActualizar.setEstado(scanner.nextLine());

                        System.out.print("Nuevo codigo postal: ");
                        domicilioActualizar.setCodigoPostal(scanner.nextLine());

                        em.close();

                        domicilioDAO.actualizar(domicilioActualizar);

                    } else {
                        System.out.println("No se encontro el domicilio.");
                        em.close();
                    }

                    break;

                case 4:
                    System.out.println("\n--- ELIMINAR DOMICILIO ---");

                    System.out.print("ID del domicilio: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();

                    domicilioDAO.eliminar(idEliminar);

                    break;

                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 5);
    }
}