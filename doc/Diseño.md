## 🎨 Diseño

### GUI
- No se implementa interfaz gráfica, toda la interacción se realiza mediante la API REST.
- La documentación y pruebas se realizan usando herramientas como Postman.

### UX 
- La usabilidad se centra en la **consistencia y claridad de la API**.
- Endpoints claros con nombres coherentes y jerarquía de recursos.
- Respuestas con códigos HTTP estándar (200, 201, 400, 404, 500) y mensajes de error descriptivos y personalizados.

### IxD 
- Los usuarios interactúan con la aplicación mediante **peticiones HTTP** (GET, POST, PUT, DELETE).
- Validaciones implementadas para evitar datos inválidos o inconsistentes.
- Manejo de errores mediante excepciones 
### Diagrama de navegación
- Diagrama conceptual de **endpoints y relaciones** entre recursos:
  - `/alumnos` ↔ listar, crear, modificar, eliminar alumnos
  - `/profesor` ↔ listar, crear, modificar, eliminar profesores
  - `/reservas` ↔ consultar, crear, modificar, cancelar reservas
  - `/cursos` ↔ consultar e inscribirse en cursos teóricos

### Reutilización
- Componentes de software reutilizables:
  - Servicios (`Service`) para lógica de negocio.
  - Repositorios (`Repository`) para acceso a datos (mock o real).
  - Mappers para convertir entre DTOs y entidades.
- Beneficio: mantiene la API consistente y facilita añadir nuevos recursos en el futuro.
## 🏗️ Arquitectura

- Arquitectura **Hexagonal** con **Vertical Slicing**.
- Separación clara entre:
  - Dominio
  - Aplicación
  - Infraestructura
- Uso de **Inversión de Control (IoC)** e **Inyección de Dependencias (DI)** con Spring Boot.

### Despliegue
- Servicio **Spring Boot REST** desplegable en cualquier contenedor o servidor.
- API consumible por clientes HTTP o front-end futuro.

### Componentes
- **Controladores (Controller):** manejan las peticiones HTTP.
- **Servicios (Service):** lógica de negocio independiente de la infraestructura.
- **Repositorios (Repository):** acceso a datos (mock para tests, base de datos real en producción).
- **Mappers:** convierten entidades a DTOs y viceversa.
- **DTOs (Request/Response):** estructuras de datos de entrada y salida de la API.
