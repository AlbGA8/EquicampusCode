# 📘 Manual de Usuario — EquiCampus

## 🏫 Introducción

Este manual describe el uso de la plataforma **EquiCampus**, una aplicación web destinada a la gestión de un centro hípico, permitiendo administrar alumnos, profesores, reservas y otros recursos del sistema.

El sistema permite realizar operaciones completas de gestión mediante un **CRUD completo (Create, Read, Update, Delete)** desde la interfaz web.

---

## 🖥️ Acceso al Sistema

1. Acceder a la URL de la aplicación (http://localhost:8082/web/dashboard).
2. Iniciar sesión con credenciales válidas. (usuario: admin@a.com password: admin)
3. Según el rol del usuario, se mostrarán las opciones disponibles.

El sistema utiliza **Spring Security** para el control de acceso.

---

## 👨‍🎓 Gestión de Alumnos (CRUD Completo)

La gestión de alumnos permite realizar las siguientes operaciones:

---

### 📋 1. Listar alumnos

Permite visualizar todos los alumnos registrados.

**Ruta API:**
GET /alumnos


**Desde el frontend:**

- Acceder al menú **Alumnos**.
- Se mostrará una tabla con la información de los alumnos:
  - Nombre  
  - Apellidos  
  - Email  
  - Nivel
  - Saldo  
  - Acciones disponibles  

---

### ➕ 2. Crear un alumno

Permite registrar un nuevo alumno en el sistema.

**Ruta API:**
POST /alumnos

**Campos requeridos:**
- Nombre  
- Apellidos  
- Email  
- Profesor  

**Pasos en el frontend:**

1. Pulsar el botón **➕ Nuevo Alumno**  
2. Completar el formulario  
3. Pulsar **Guardar**

El sistema valida los datos usando:
- Spring Validation  
- Validaciones en backend y frontend  

---

### ✏️ 3. Editar alumno

Permite modificar la información de un alumno existente.

**Ruta API:**
PUT /alumnos/{id}

**Pasos:**

1. Pulsar el botón **✏️ Editar** en la tabla.  
2. Se abrirá el formulario con los datos actuales.  
3. Modificar la información.  
4. Confirmar los cambios.

Se utiliza:
- Thymeleaf  
- HTMX para actualizaciones asíncronas sin recargar la página.

---

### ❌ 4. Eliminar alumno

Permite eliminar un alumno del sistema.

**Ruta API:**
DELETE /alumnos/{id}

**Pasos:**

1. Pulsar el botón **🗑️ Eliminar**.  
2. Confirmar la acción.

⚠️ Esta acción es irreversible.

HTMX permite actualizar la tabla automáticamente tras la eliminación.

---

## 👨‍🏫 Gestión de Profesores

El sistema implementa las mismas operaciones para la entidad **Profesor**.

### Endpoints equivalentes:

| Operación | Endpoint |
|-----------|----------|
| Listar | GET /profesor |
| Crear | POST /profesor |
| Editar | PUT /profesor/{id} |
| Eliminar | DELETE /profesor/{id} |

---

## 🎨 Uso del Frontend (Thymeleaf + HTMX)

La aplicación utiliza:

### Thymeleaf
- Permite generar vistas dinámicas desde el backend.
- Facilita la integración con Spring Boot.

### HTMX
Permite:
- Actualizaciones parciales de la página.
- Comunicación asíncrona con el backend.
- Mejor experiencia de usuario.

Ejemplos de uso:
- Actualización de tablas sin recargar la página completa.
- Formularios dinámicos.

---

## 🔐 Seguridad

El acceso a funcionalidades está protegido mediante roles:

- Administrador → Acceso total.
- Usuario → Acceso limitado.

Implementado con:
- Spring Security  
- Control de sesiones  

---

## 📄 Generación de Documentos

El sistema permite exportar información en formato PDF utilizando:

- Flying Saucer  
- OpenHTMLToPDF  

Ejemplo:
- Exportación de listados de alumnos.

---

## ⚠️ Mensajes de Error

El sistema mostrará mensajes cuando:

- Falten campos obligatorios.
- El formato del correo no sea válido.
- No se tenga permiso para realizar una acción.
