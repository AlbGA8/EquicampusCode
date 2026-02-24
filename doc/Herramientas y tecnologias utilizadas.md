

## 🛠️ Herramientas y Tecnologías Utilizadas

Durante el desarrollo del proyecto se emplearon diversas herramientas y tecnologías que permitieron mejorar la organización, mantenibilidad y experiencia del sistema.

### 🎨 Frontend y Renderizado

- **Thymeleaf** → Motor de plantillas del lado del servidor para la generación de vistas dinámicas.
- **Thymeleaf Fragments** → Reutilización de componentes como Sidebar y Topbar, favoreciendo la modularidad.
- **HTMX** → Interactividad avanzada sin necesidad de SPA, permitiendo actualización parcial del DOM.
- **Tailwind CSS** → Diseño responsive y consistente mediante utilidades CSS.

---

### 🔐 Seguridad

- **Spring Security** → Autenticación y autorización basada en roles.
- **BCryptPasswordEncoder** → Encriptación segura de contraseñas.
- **Control RBAC (Role-Based Access Control)** → Restricción de endpoints según permisos.

---

### 📄 Documentación y API

- **OpenAPI (springdoc-openapi)** → Estandarización de la documentación REST.
- **Swagger UI** → Interfaz interactiva para pruebas y visualización de endpoints.
- **Arquitectura RESTful** → Diseño estructurado de servicios web.

---

### 🗄️ Persistencia y Base de Datos

- **Spring Data JPA** → Abstracción de acceso a datos.
- **Hibernate** → Implementación ORM.
- **MySQL** → Sistema gestor de base de datos relacional.

---

### 🧪 Desarrollo y Productividad

- **Maven** → Gestión de dependencias y ciclo de vida del proyecto.
- **Lombok** → Reducción de código repetitivo.
- **Spring Boot DevTools** → Recarga automática durante el desarrollo.
- **JUnit 5** → Pruebas unitarias.
- **Postman**  → Testing manual de endpoints.

---

### 🐳 Contenerización y Despliegue

- **Docker** → Contenerización de la aplicación.
- **Docker Compose**  → Orquestación de servicios (app + base de datos).

---

### 📑 Generación de Documentos

- **OpenHTMLToPDF**
- **Flying Saucer**

Permitiendo la generación dinámica de documentos PDF desde plantillas HTML.

---

## 🎯 Impacto de las Herramientas en el Proyecto

La combinación de estas tecnologías permitió:

- Mejorar la experiencia de usuario sin recurrir a frameworks SPA complejos.
- Mantener una arquitectura limpia y desacoplada.
- Facilitar el mantenimiento y escalabilidad futura.
- Garantizar estándares modernos de seguridad y documentación.