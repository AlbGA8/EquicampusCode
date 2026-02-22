# 🛡️ Documentación de Autenticación — EquiCampus (Spring Security)

Este proyecto implementa un sistema de autenticación y autorización basado en **Spring Security** dentro de un entorno **Spring Boot**, siguiendo principios de **arquitectura limpia (Clean Architecture)**.

La seguridad está desacoplada del dominio principal, lo que permite:

- Mayor mantenibilidad  
- Separación clara de responsabilidades  
- Facilidad para realizar pruebas unitarias  
- Flexibilidad para futuras extensiones (JWT, OAuth2, etc.)

---

# 🏗️ Arquitectura de Seguridad

La implementación de seguridad se organiza principalmente en la capa de **Infrastructure**, interactuando con la persistencia para validar credenciales y gestionar la autenticación.

---

## 1️⃣ Capa de Dominio (`auth/domain`)

En esta capa se definen los modelos de negocio puros, completamente independientes de frameworks externos.

### Componentes principales:

- **Usuario** → Entidad de dominio que representa la identidad del sistema.  
- **Rol** → Define agrupaciones de permisos (ej: ADMIN, USER).  
- **Permiso** → Representa acciones específicas dentro del sistema.  
- **UsuarioId** → Value Object que garantiza la integridad referencial del identificador del usuario.

🔎 Característica clave:  
Esta capa no depende de Spring Security ni de JPA. Solo contiene lógica de negocio.

---

## 2️⃣ Capa de Infraestructura (`auth/infrastructure`)

Aquí se encuentra la implementación técnica concreta de la seguridad.

| Componente        | Ubicación            | Descripción |
|------------------|----------------------|------------|
| **SecurityConfig** | `config/` | Clase principal de configuración. Define `SecurityFilterChain`, manejo de CORS, CSRF y reglas de autorización (RBAC). |
| **UserEntity** | `db/jpa/entity/` | Representación de la tabla en base de datos. Es utilizada por Spring Security mediante un `UserDetailsService`. |
| **UserAuth** | `security/` | Implementa `UserDetails`. Actúa como puente entre la entidad de base de datos y el concepto de "Principal" de Spring Security. |
| **UserMapper** | `mapper/` | Transforma `UserEntity` (infraestructura) en `Usuario` (dominio) y viceversa, manteniendo el desacoplamiento entre capas. |

---

# 🔐 Flujo de Autenticación

El proceso de autenticación sigue los siguientes pasos:

1. **Entrada:**  
   El cliente envía las credenciales al `AuthController`.

2. **Intercepción:**  
   `SecurityConfig` intercepta la petición mediante el `SecurityFilterChain`.

3. **Validación:**  
   Se utiliza un `AuthenticationManager` para validar las credenciales.

4. **Consulta a Persistencia:**  
   Se consulta el `UserEntityRepository` para buscar al usuario por nombre o email.

5. **Mapeo:**  
   El `UserMapper` transforma la entidad de base de datos al modelo de dominio o al contexto de seguridad (`UserDetails`).

6. **Autorización:**  
   Se verifican los **roles (Rol)** y **permisos (Permiso)** definidos en el dominio para determinar si el acceso es permitido.

---

# 🛠️ Configuración Principal — `SecurityConfig.java`

Este archivo gestiona los aspectos críticos del sistema de seguridad:

### 🔹 Políticas de Sesión
- Stateful (sesión tradicional con formulario)
- Stateless (en caso de utilizar JWT)

### 🔹 Endpoints Públicos
- `/login`
- `/register`
- Recursos estáticos

### 🔹 Endpoints Protegidos
- Rutas que requieren autenticación
- Restricción por roles específicos (`ADMIN`, `USER`, etc.)

### 🔹 Codificación de Contraseñas

Se utiliza `BCryptPasswordEncoder` para almacenar contraseñas de forma segura.

Ventajas:
- Las contraseñas no se almacenan en texto plano  
- Protección ante filtraciones de base de datos  
- Algoritmo seguro recomendado por Spring Security  

---

# 🧠 Nota de Arquitectura

El `AuthController` se encuentra fuera de la capa `infrastructure`, lo que indica que actúa como un **Adapter (punto de entrada)** que comunica el mundo exterior (HTTP) con la lógica interna de la aplicación.

Esto respeta el principio de inversión de dependencias:

> La infraestructura depende del dominio, pero el dominio no depende de la infraestructura.

---

# ✅ Beneficios de la Implementación

- Separación clara entre dominio y framework
- Seguridad desacoplada y mantenible
- Arquitectura preparada para escalar (JWT, OAuth2, microservicios)
- Cumplimiento de principios SOLID
- Implementación alineada con Clean Architecture y Hexagonal Architecture

---

# 🎯 Conclusión

La autenticación en EquiCampus no solo cumple con los estándares de seguridad de Spring Security, sino que está diseñada bajo principios arquitectónicos sólidos.

Esto permite que el sistema sea:

- Seguro  
- Escalable  
- Mantenible  
- Fácilmente testeable  

La implementación garantiza un control robusto de identidad y acceso sin comprometer la estructura del dominio principal.