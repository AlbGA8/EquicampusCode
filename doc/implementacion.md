## 🖥️ Implementación

### ⚙️ Entorno de Desarrollo

El proyecto se desarrolló utilizando un entorno basado en tecnologías Java modernas y herramientas de desarrollo de aplicaciones web empresariales.

Se utilizó un sistema de control de versiones basado en la **versión 1.0 de la API**, permitiendo una correcta evolución del sistema.

#### Tecnologías principales

- **Lenguaje:** Java 17  
- **Framework backend:** Spring Boot  
- **Gestión de dependencias y construcción:** Maven  
- **Despliegue:** Docker  
- **Base de datos:** MySQL  
- **Motor de plantillas:** Thymeleaf  
- **Seguridad:** Spring Security  
- **Validación:** Spring Validation  
- **Cache:** Spring Cache  
- **Documentación de la API:** OpenAPI + Swagger UI  

---

### 📄 Documentación de la API

Se integró **OpenAPI con Swagger UI** para facilitar la documentación y prueba de los endpoints del sistema de forma interactiva.

Esto permitió:
- Mejor comprensión de los servicios REST.  
- Facilitar el testing de la API.  
- Mejorar la comunicación entre frontend y backend.

---

### 📦 Versiones de herramientas utilizadas

| Herramienta | Versión |
|------------|---------|
| Java | 17 |
| Spring Boot | 3.5.7 |
| Maven | 3.x |
| Docker | 28.4.0 |
| OpenAPI (springdoc) | 2.8.15 |

---

### 🧩 Dependencias destacadas

El proyecto incluye las siguientes dependencias principales:

- Spring Boot Starter Web → Desarrollo de APIs REST.  
- Spring Boot Starter Security → Control de acceso y autenticación.  
- Spring Data JPA → Persistencia de datos.  
- Thymeleaf + Thymeleaf Security Extras → Renderizado de vistas dinámicas.  
- OpenHTMLToPDF + Flying Saucer → Generación de documentos PDF.  
- Lombok → Reducción de código repetitivo.  
- Spring Boot DevTools → Recarga automática durante el desarrollo.  

---

### 🐳 Despliegue con Docker

El sistema se desplegó utilizando contenedores Docker, permitiendo:

- Aislamiento del entorno de ejecución.  
- Facilitar la implantación en producción.  
- Simplificar la configuración del sistema.

---

### 🔐 Seguridad

Se ha implementado seguridad mediante:

- Spring Security.  
- Control de acceso basado en roles.  
- Protección de endpoints sensibles.

---

## ⭐ Valor añadido del sistema

- Arquitectura moderna basada en buenas prácticas de diseño.  
- Integración de documentación automática de la API.  
- Uso de tecnologías para mejorar la experiencia del usuario (HTMX + Thymeleaf).  
- Generación automática de documentos PDF.

> La selección de estas tecnologías permitió desarrollar una aplicación escalable, mantenible y preparada para su posible evolución hacia un entorno de producción real.