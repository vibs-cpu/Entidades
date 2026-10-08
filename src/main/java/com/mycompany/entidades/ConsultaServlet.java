package com.mycompany.entidades;

import com.mycompany.entidades.dao.DomicilioDAO;
import com.mycompany.entidades.dao.PersonaDAO;
import com.mycompany.entidades.dao.UsuarioDAO;

import com.mycompany.entidades.modelo.Domicilio;
import com.mycompany.entidades.modelo.Persona;
import com.mycompany.entidades.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tabla = request.getParameter("tabla");

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");

        response.getWriter().println("<meta charset='UTF-8'>");

        response.getWriter().println(
                "<title>Sistema de gestión de usuarios</title>"
        );

        // ==========================================
        // ESTILOS
        // ==========================================

        response.getWriter().println("<style>");

        response.getWriter().println(
                "body {"
                + "font-family: Arial, sans-serif;"
                + "margin: 0;"
                + "padding: 0;"
                + "background-color: #f4f4f4;"
                + "}"
        );

        response.getWriter().println(
                ".contenedor {"
                + "width: 90%;"
                + "max-width: 1200px;"
                + "margin: 40px auto;"
                + "background-color: white;"
                + "padding: 30px;"
                + "}"
        );

        response.getWriter().println(
                "h1 {"
                + "text-align: center;"
                + "margin-bottom: 40px;"
                + "}"
        );

        response.getWriter().println(
                ".contenido {"
                + "display: flex;"
                + "gap: 40px;"
                + "align-items: flex-start;"
                + "}"
        );

        response.getWriter().println(
                ".tabla {"
                + "width: 60%;"
                + "overflow-x: auto;"
                + "}"
        );

        response.getWriter().println(
                ".integrantes {"
                + "width: 40%;"
                + "text-align: center;"
                + "padding-top: 20px;"
                + "}"
        );

        response.getWriter().println(
                "table {"
                + "border-collapse: collapse;"
                + "width: 100%;"
                + "}"
        );

        response.getWriter().println(
                "th, td {"
                + "border: 1px solid black;"
                + "padding: 10px;"
                + "text-align: left;"
                + "}"
        );

        response.getWriter().println(
                "th {"
                + "background-color: #eaeaea;"
                + "}"
        );

        response.getWriter().println(
                ".volver {"
                + "margin-top: 30px;"
                + "}"
        );

        response.getWriter().println(
                ".volver a {"
                + "display: inline-block;"
                + "padding: 10px 20px;"
                + "background-color: #333;"
                + "color: white;"
                + "text-decoration: none;"
                + "}"
        );

        response.getWriter().println("</style>");

        response.getWriter().println("</head>");

        response.getWriter().println("<body>");

        response.getWriter().println("<div class='contenedor'>");

        // ==========================================
        // TÍTULO
        // ==========================================

        response.getWriter().println(
                "<h1>Sistema de gestión de usuarios</h1>"
        );

        response.getWriter().println("<div class='contenido'>");

        // ==========================================
        // PARTE IZQUIERDA
        // ==========================================

        response.getWriter().println("<div class='tabla'>");

        // ==========================================
        // USUARIOS
        // ==========================================

        if ("usuarios".equals(tabla)) {

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            List<Usuario> usuarios = usuarioDAO.consultarWeb();

            response.getWriter().println("<h2>Usuarios</h2>");

            response.getWriter().println("<table>");

            response.getWriter().println("<tr>");
            response.getWriter().println("<th>ID</th>");
            response.getWriter().println("<th>Usuario</th>");
            response.getWriter().println("</tr>");

            for (Usuario usuario : usuarios) {

                response.getWriter().println("<tr>");

                response.getWriter().println(
                        "<td>" + usuario.getIdUsuario() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + usuario.getNombreUsuario() + "</td>"
                );

                response.getWriter().println("</tr>");
            }

            response.getWriter().println("</table>");
        }

        // ==========================================
        // PERSONAS
        // ==========================================

        else if ("personas".equals(tabla)) {

            PersonaDAO personaDAO = new PersonaDAO();

            List<Persona> personas = personaDAO.consultarWeb();

            response.getWriter().println("<h2>Personas</h2>");

            response.getWriter().println("<table>");

            response.getWriter().println("<tr>");
            response.getWriter().println("<th>ID</th>");
            response.getWriter().println("<th>Nombre</th>");
            response.getWriter().println("<th>Apellido Paterno</th>");
            response.getWriter().println("<th>Apellido Materno</th>");
            response.getWriter().println("<th>Teléfono</th>");
            response.getWriter().println("<th>Correo</th>");
            response.getWriter().println("</tr>");

            for (Persona persona : personas) {

                response.getWriter().println("<tr>");

                response.getWriter().println(
                        "<td>" + persona.getIdPersona() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + persona.getNombre() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + persona.getApellidoPaterno() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + persona.getApellidoMaterno() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + persona.getTelefono() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + persona.getCorreo() + "</td>"
                );

                response.getWriter().println("</tr>");
            }

            response.getWriter().println("</table>");
        }

        // ==========================================
        // DOMICILIOS
        // ==========================================

        else if ("domicilios".equals(tabla)) {

            DomicilioDAO domicilioDAO = new DomicilioDAO();

            List<Domicilio> domicilios = domicilioDAO.consultarWeb();

            response.getWriter().println("<h2>Domicilios</h2>");

            response.getWriter().println("<table>");

            response.getWriter().println("<tr>");
            response.getWriter().println("<th>ID</th>");
            response.getWriter().println("<th>Calle</th>");
            response.getWriter().println("<th>Número</th>");
            response.getWriter().println("<th>Colonia</th>");
            response.getWriter().println("<th>Municipio</th>");
            response.getWriter().println("<th>Estado</th>");
            response.getWriter().println("<th>Código Postal</th>");
            response.getWriter().println("</tr>");

            for (Domicilio domicilio : domicilios) {

                response.getWriter().println("<tr>");

                response.getWriter().println(
                        "<td>" + domicilio.getIdDomicilio() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getCalle() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getNumero() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getColonia() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getMunicipio() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getEstado() + "</td>"
                );

                response.getWriter().println(
                        "<td>" + domicilio.getCodigoPostal() + "</td>"
                );

                response.getWriter().println("</tr>");
            }

            response.getWriter().println("</table>");
        }

        // ==========================================
        // OPCIÓN NO RECONOCIDA
        // ==========================================

        else {

            response.getWriter().println(
                    "<p>No se seleccionó una tabla válida.</p>"
            );
        }

        response.getWriter().println("</div>");

        // ==========================================
        // PARTE DERECHA: INTEGRANTES
        // ==========================================

        response.getWriter().println("<div class='integrantes'>");

        response.getWriter().println(
                "<h2>Integrantes del equipo</h2>"
        );

        response.getWriter().println(
                "<p>Bautista Sanchez Victor Manuel</p>"
        );

        response.getWriter().println(
                "<p>De la Cruz Trinidad Candido Enrique</p>"
        );

        response.getWriter().println("</div>");

        response.getWriter().println("</div>");

        // ==========================================
        // BOTÓN VOLVER
        // ==========================================

        response.getWriter().println("<div class='volver'>");

        response.getWriter().println(
                "<a href='index.jsp'>← Volver</a>"
        );

        response.getWriter().println("</div>");

        response.getWriter().println("</div>");

        response.getWriter().println("</body>");

        response.getWriter().println("</html>");
    }
}