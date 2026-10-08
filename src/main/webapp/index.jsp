<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema de gestión de usuarios</title>
        <style>

            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            .contenedor {
                width: 90%;
                max-width: 1000px;
                margin: 50px auto;
                background-color: white;
                padding: 30px;
            }

            h1 {
                text-align: center;
                margin-bottom: 40px;
            }

            .contenido {
                display: flex;
                gap: 50px;
            }

            .consulta {
                width: 50%;
            }

            .integrantes {
                width: 50%;
                text-align: center;
            }

            select {
                width: 250px;
                padding: 10px;
                font-size: 16px;
            }

            button {
                margin-top: 20px;
                padding: 10px 25px;
                font-size: 16px;
                cursor: pointer;
            }

            .integrantes p {
                margin: 15px;
            }

        </style>

    </head>

    <body>

        <div class="contenedor">

            <h1>Sistema de gestión de usuarios</h1>

            <div class="contenido">

                <div class="consulta">

                    <h2>Consulta de información</h2>

                    <p>Seleccione una tabla:</p>

                    <form action="ConsultaServlet" method="get">

                        <select name="tabla">

                            <option value="usuarios">Usuarios</option>

                            <option value="personas">Personas</option>

                            <option value="domicilios">Domicilios</option>

                        </select>

                        <br>

                        <button type="submit">
                            CONSULTAR
                        </button>

                    </form>

                </div>

                <div class="integrantes">

                    <h2>Integrantes del equipo</h2>

                    <p>Bautista Sanchez Victor Manuel</p>

                    <p>De la Cruz Trinidad Candido Enrique</p>

                </div>

            </div>

        </div>

    </body>

</html>