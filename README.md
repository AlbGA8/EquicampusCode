# EquiCampus API 🐴

## 📄 Descripción
EquiCampus es una aplicación REST diseñada para la gestión de **alumnos, profesores, caballos, clases y cursos** en un centro ecuestre.  
Permite crear, consultar, modificar y eliminar alumnos y profesores, gestionar reservas de clases y cursos teóricos, y consultar pagos y calendario general.

El objetivo de esta API es **facilitar la administración del centro** y ofrecer un acceso rápido y estructurado a la información para aplicaciones front-end o sistemas de terceros.

---

## 📚 Índice de Documentación del Proyecto

| Sección del Documento | Enlace al Archivo | Archivo en Carpeta `doc/` |
| :--- | :--- | :--- |
| Contexto de la Aplicación | [Contexto del Proyecto](doc/EquiCampus%20Contexto.md) | `EquiCampus Contexto.md` |
| Mundo Real del Problema | [Problema y Solución](doc/Problema%20y%20Solucion.md) | `Problema y Solucion.md` |
| Casos de Uso y Requisitos | [Caso de Uso y Requisitos](doc/Caso%20de%20uso%20y%20requisitos%20funcionales%20y%20no%20funcionales.md) | `Caso de uso y requisitos funcionales y no funcionales.md` |
| Servicios REST | [Diseño de Servicios REST](doc/Diseño%20Servicios%20REST.md) | `Diseño Servicios REST.md` |
| Base de Datos | [Diseño de la Base de Datos](doc/Base%20de%20datos.md) | `Base de datos.md` |
| Autenticación y Seguridad | [Autenticación](doc/Autenticacion.md) | `Autenticacion.md` |
| UI y Tecnologías Frontend | [UI y Tecnologías Frontend](doc/UI-UX-IxD.md) | `UI y tecnologias Frontedn.md` |
| Plan de Pruebas | [Plan de Pruebas](doc/plan%20de%20pruebas.md) | `plan de pruebas.md` |
| Implementación| [Implementación](doc/implementacion.md) | `implementacion.md` |
|Herramientas utilizadas | [Herramientas utilizadas](doc/Herramientas%20y%20tecnologias%20utilizadas.md) | `Herramientas y tecnologias utilizadas.md` |
| Capturas de Funcionalidad | [Capturas](doc/capturas%20de%20la%20funcionalidad.md) | `capturas de la funcionalidad.md` |
| Elementos Destacables | [Destacados](doc/Elementos%20destacados.md) | `Elementos destacados.md` |
| Manual de Usuario | [Manual de Usuario](doc/manual%20de%20usuario.md) | `manual de usuario.md` |
| Conclusiones | [Conclusiones](doc/conclusiones.md) | `conclusiones.md` |
| Bibliografía | [Bibliografía](doc/bibliografia.md) | `bibliografia.md` |

---

## ⚙️ Funcionalidades principales

- Gestión completa de **Alumnos y Profesores**.
- Gestión de **clases, cursos y reservas**.
- Autenticación y control de acceso.
- Operaciones CRUD mediante API REST (`GET`, `POST`, `PUT`, `DELETE`).

---

## 🧪 Plan de pruebas

Se han implementado pruebas de integración utilizando:

- **JUnit 5**
- **MockMvc**

Validaciones realizadas:

- Creación, modificación y eliminación de registros.
- Validación de campos obligatorios.
- Consultas GET para verificar respuestas correctas.

Más información:  
👉 [Plan de pruebas](doc/plan%20de%20pruebas.md)

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
