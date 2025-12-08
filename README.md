# EquiCampus API 🐴

## 📄 Descripción
EquiCampus es una aplicación REST diseñada para la gestión de **alumnos, profesores, caballos, clases y cursos** en un centro ecuestre.  
Permite crear, consultar, modificar y eliminar alumnos y profesores, gestionar reservas de clases y cursos teóricos, y consultar pagos y calendario general.

El objetivo de esta API es **facilitar la administración del centro** y ofrecer un acceso rápido y estructurado a la información para aplicaciones front-end o sistemas de terceros.

Tienes toda la documentacion aqui: ## 📚 Índice de Documentación del Proyecto

| Sección del Documento | Enlace al Archivo | Archivo en Carpeta `doc/` |
| :--- | :--- | :--- |
| **Contexto de la Aplicación** | [Contexto del Proyecto](doc/EquiCampus%20Contexto.md) | `EquiCampus Contexto.md` |
| **Mundo Real del Problema** | [Problema y Solución](doc/Problema%20y%20Solucion.md) | `Problema y Solucion.md` |
| **Casos de Uso, Requisitos F y NFF** | [Caso de Uso y Requisitos](doc/Caso%20de%20uso%20y%20requisitos%20funcionales%20y%20no%20funcionales.md) | `Caso de uso y requisitos funcionales y no funcionales.md` |
| **Diseño** | [Diseño General](doc/Diseño.md) | `Diseño.md` |
| **Diseño de los Servicios REST** | [Diseño de Servicios REST](doc/Diseño%20Servicios%20REST.md) | `Diseño Servicios REST.md` |
| **Base de Datos** | [Diseño de la Base de Datos](doc/Base%20de%20datos.md) | `Base de datos.md` |
| **Plan de Pruebas** | [Plan de Pruebas](doc/plan%20de%20pruebas.md) | `plan de pruebas.md` |
| **Implementación** | [Detalles de Implementación](doc/implementacion.md) | `implementacion.md` |
| **Información sobre Herramientas** | [Información Herramientas y Función](doc/Informacion%20herramientas%20y%20funcion.md) | `Informacion herramientas y funcion.md` |
| **Capturas de la Funcionalidad** | [Capturas de la Funcionalidad](doc/capturas%20de%20la%20funcionalidad.md) | `capturas de la funcionalidad.md` |
| **Elementos Destacables** | [Elementos Destacados](doc/Elementos%20destacados.md) | `Elementos destacados.md` |
| **Manual de Usuario** | [Manual de Usuario](doc/manual%20de%20usuario.md) | `manual de usuario.md` |
| **Conclusiones** | [Conclusiones del Proyecto](doc/conclusiones.md) | `conclusiones.md` |
| **Bibliografía** | [Bibliografía y Referencias](doc/bibliografia.md) | `bibliografia.md` |

---

---

## ⚙️ Funcionalidades principales

- Gestión de **Alumnos** y **Profesores**.
- Operaciones completas mediante endpoints **REST** (`GET`, `POST`, `PUT`, `DELETE`).
---

## 📂 Estructura del proyecto

- `alumno/` → Gestión de alumnos y sus servicios.
- `profesor/` → Gestión de profesores y sus servicios.
- `infraestructure/` → Controladores REST, repositorios y mock data.
- `application/` → Lógica de negocio (servicios y comandos).
- `domain/` → Entidades y modelos de identificación.

---

## 🧪 Plan de pruebas
Se han implementado pruebas de integración usando **JUnit 5** y **MockMvc** para validar todos los endpoints.  
- Test de creación, modificación y eliminación de alumnos y profesores.
- Validaciones de datos obligatorios (nombre, apellidos, profesor asignado).
- Consultas con GET para verificar que la lista de datos devuelta coincide con los mocks.

Para más detalles: [Plan de pruebas](doc/plan%20de%20pruebas.md)

---

## 🚀 Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/AlbGA8/EquicampusCode.git

mvn clean install

mvn spring-boot:run

http://localhost:8080
```
