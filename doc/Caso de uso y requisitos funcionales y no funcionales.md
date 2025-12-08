## 🧭 Casos de Uso por Rol

| **Caso de Uso**                           | **Alumno** | **Instructor** | **Administrador** |
| ----------------------------------------- | ---------- | -------------- | ----------------- |
| CU00.Asignar Caballos                     | ❌          | ✅              | ✅                 |
| CU01. Consultar caballos                  | ✅          | ✅              | ✅                 |
| CU02. Consultar pistas                    | ✅          | ✅              | ✅                 |
| CU03. Reservar clase práctica             | ✅          | ❌              | ❌                 |
| CU04. Modificar / cancelar reserva        | ✅          | ❌              | ✅                 |
| CU05. Consultar reservas                  | ✅          | ✅              | ✅                 |
| CU06. Inscribirse en curso teórico        | ✅          | ❌              | ❌                 |
| CU07. Consultar/Modificar cursos teóricos | ✅          | ✅              | ✅                 |
| CU08. Registrar / consultar pagos         | ✅          | ❌              | ✅                 |
| CU09. Consultar calendario general        | ✅          | ✅              | ✅                 |
| CU10. Dar de alta alumno                  | ❌          | ❌              | ✅                 |
| CU11. Modificar Alumno                    | ✅          | ❌              | ✅                 |
| CU12. Obtener lista de alumnos            | ❌          | ✅              | ✅                 |
| CU13. Borrar alumno                       | ❌          | ❌              | ✅                 |
| CU14. Dar de alta profesor                | ❌          | ❌              | ✅                 |
| CU15. modificar profesor                  | ❌          | ✅              | ✅                 |
| CU16.Obtener lista de profesores          | ❌          | ✅              | ✅                 |
| CU17. Borrar profesor                     | ❌          | ❌              | ✅                 |
## ⚙️ Requisitos  Funcionales (RF)

| **Código** | **Requisito**                               | **Descripción / Criterio de Aceptación**                                                                   |
| ---------- | ------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **RF01**   | Asignar caballos                            | Listado de alumnos donde se inserta un caballo disponible                                                  |
| **RF02**   | Consultar caballos: asignados o sin asignar | Listado de caballos disponibles o asignados segun el alumno seleccionado por ID                            |
| **RF03**   | Consultar pistas                            | Listado de pistas disponibles                                                                              |
| **RF04**   | Reservar clase práctica                     | Listado de clases disponibles                                                                              |
| **RF05**   | Modificar / cancelar reserva                | Listado de reservas realizadas donde puedes modificar la fecha o cancelar esa reserva                      |
| **RF06**   | Consultar reservas                          | Listado de todas las reservas realizadas(caballos,pistas,clases)                                           |
| **RF07**   | Inscribirse en curso teórico                | Listado de los cursos teóricos disponibles por fecha donde puedes seleccionar y reservar con ID del alumno |
| **RF08**   | Consultar/Modificar cursos teóricos         | Listado con todos los cursos teóricos reservados                                                           |
| **RF09**   | Registrar / consultar pagos                 | Listado con los pagos realizados por el alumno                                                             |
| **RF10**   | Consultar calendario general                | Visualización del calendario con reservas, clases, cursos y eventos asignados según el rol del usuario.    |


## ## ⚙️ Requisitos No Funcionales (RNF)

| **Código** | **Requisito**              | **Descripción / Criterio de Aceptación**                                                                                 |
| ---------- | -------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **RNF01**  | Autenticación obligatoria  | Todo usuario deben iniciar sesión para acceder a la plataforma y a sus reservas.                                         |
| **RNF02**  | Control de roles           | Cada rol solo puede acceder a los recursos permitidos.                                                                   |
| **RNF03**  | Datos cifrados             | Las comunicaciones entre cliente y servidor deben usar HTTPS para proteger datos personales de alumnos y profesores.     |
| **RNF04**  | Tiempo de respuesta        | Las operaciones de consulta deben responder en **menos de 2 segundos**.                                                  |
| **RNF05**  | Escalabilidad              | El sistema debe ser capaz de manejar un aumento de los usuarios                                                          |
| **RNF06**  | Concurrencia               | La plataforma debe permitir múltiples reservas simultáneas sin generar conflictos en la asignación de pistas y caballos. |
| **RNF07**  | Disponibilidad             | El sistema debe estar disponible                                                                                         |
| **RNF08**  | Recuperación ante errores  | En caso de fallo, el sistema debe recuperar la operatividad lo antes posible                                             |
| **RNF09**  | Integridad                 | No se permite la creación de reservas duplicadas ni asignaciones inconsistentes de caballos/pistas.                      |
| **RNF10**  | Código modular             | La arquitectura debe estar separada en capas                                                                             |
| **RNF11**  | Trazabilidad               | Cada requisito funcional debe estar asociado a un test unitario o de integración.                                        |
| **RNF13**  | Interfaz intuitiva         | La UI debe permitir navegar entre reservas, cursos y caballos en un máximo de **3 clics**.                               |
| **RNF14**  | Accesibilidad              | La interfaz debe cumplir criterios básicos de accesibilidad (tamaños de letra, contraste, mensajes de error claros).     |
| **RNF15**  | Consistencia visual        | Todas las pantallas deben seguir la misma estructura (cabecera, menú lateral, zona de contenido).                        |
| **RNF16**  | Compatible con navegadores | La aplicación web debe funcionar correctamente los navegadores mas usados                                                |
| **RNF17**  | Base de datos consistente  | Toda la información debe guardarse de manera persistente en la BD.                                                       |
| **RNF18**  | No pérdida de datos        | Ninguna operación crítica puede perderse tras un reinicio del servidor.                                                  |
