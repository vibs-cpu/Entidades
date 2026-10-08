## alumnos 
* Baustista Sanchez Victor Manuel
* De la Cruz Trinidad Candido Enrique
# Sistema de Gestión de Usuarios (JPA + JSP + MySQL)
--
## 🚀 Descripción del Proyecto
Este sistema está desarrollado en **Java** (utilizando Servlets, JSP y JPA para la gestión de la base de datos) y funciona como un sistema **CRUD** completo (Crear, Leer, Actualizar y Eliminar).

---

## 🗂️ Opciones del Menú (`index.jsp`)

* **Insertar usuario** (`INSERTAR.jsp`): Permite registrar un usuario nuevo.
* **Consultar usuarios** (`LISTA.jsp`): Muestra la lista completa de todos los usuarios registrados.
* **Buscar** (`BUSCAR.jsp`): Facilita encontrar a un usuario en específico.
* **Actualizar usuario** (`ACTUALIZAR.jsp`): Permite modificar los datos de un usuario existente.
* **Eliminar** (`eliminar.jsp`): Borra un registro de usuario.
* **Salir** (`index.jsp`): Recarga la misma página principal.

---

## 📂 Estructura del Proyecto

* **`index.jsp` (La Vista / Menú):** Interfaz web que muestra las opciones principales mediante enlaces.
* **`usuario.java` (El Modelo):** Clase mapeada con JPA (`@Entity`) que representa la tabla `usuario` en la base de datos (con sus atributos, constructores, Getters/Setters y consultas predefinidas).
