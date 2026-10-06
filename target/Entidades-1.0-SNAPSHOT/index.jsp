<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema de Entidades</title>
    </head>

    <body>

        <h1>Sistema de Entidades</h1>

        <p>Seleccione una tabla:</p>

        <form action="ConsultaServlet" method="get">

            <select name="tabla">

                <option value="usuarios">Usuarios</option>
                <option value="personas">Personas</option>
                <option value="domicilios">Domicilios</option>

            </select>

            <br><br>

            <button type="submit">CONSULTAR</button>

        </form>

    </body>
</html>