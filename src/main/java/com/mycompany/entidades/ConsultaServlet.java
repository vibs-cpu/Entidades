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
        response.getWriter().println("<title>Sistema de Entidades</title>");

        response.getWriter().println("<style>");

        response.getWriter().println("body {");
        response.getWriter().println("    font-family: Arial, sans-serif;");
        response.getWriter().println("    margin: 30px;");
        response.getWriter().println("}");

        response.getWriter().println(".contenido {");
        response.getWriter().println("    display: flex;");
        response.getWriter().println("    width: 100%;");
        response.getWriter().println("}");

        response.getWriter().println(".tabla {");
        response.getWriter().println("    width: 50%;");
        response.getWriter().println("}");

        response.getWriter().println(".integrantes {");
        response.getWriter().println("    width: 50%;");
        response.getWriter().println("    text-align: center;");
        response.getWriter().println("    padding-top: 40px;");
        response.getWriter().println("}");

        response.getWriter().println("table {");
        response.getWriter().println("    border-collapse: collapse;");
        response.getWriter().println("}");

        response.getWriter().println("th, td {");
        response.getWriter().println("    border: 1px solid black;");
        response.getWriter().println("    padding: 10px;");
        response.getWriter().println("}");

        response.getWriter().println("</style>");

        response.getWriter().println("</head>");

        response.getWriter().println("<body>");

        response.getWriter().println("<h1>Sistema de Entidades</h1>");

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
                    "<p>Seleccionaste: " + tabla + "</p>"
            );
        }

        response.getWriter().println("</div>");

        // ==========================================
        // PARTE DERECHA: INTEGRANTES
        // ==========================================

        response.getWriter().println("<div class='integrantes'>");

        response.getWriter().println("<h3>Integrantes:</h3>");

        response.getWriter().println(
                "<p>Bautista Sanchez Victor Manuel</p>"
        );

        response.getWriter().println(
                "<p>De la Cruz Trinidad Candido Enrique</p>"
        );

        response.getWriter().println("</div>");

        response.getWriter().println("</div>");

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}