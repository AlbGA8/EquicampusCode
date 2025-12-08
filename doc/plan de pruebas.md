## 📝 Plan de Pruebas
### 1️⃣ Objetivo

Comprobar que la API REST cumple los **requisitos funcionales** y que las operaciones sobre Alumnos y Profesores funcionan correctamente. Se validan tanto los casos positivos como los negativos, incluyendo errores de validación.
### 2️⃣ Alcance

Se probarán los siguientes endpoints:

- `/alumnos` → GET, POST, PUT, DELETE
    
- `/profesor` → GET, POST, PUT, DELETE
    

Además se verifican:

- Validaciones de campos obligatorios
    
- Gestión de errores (códigos HTTP)
    
- Integridad de datos (relación alumno-profesor)

### 3️⃣ Tipos de pruebas

-  **Unitarias** : JUnit5 Pruebas de servicios, mappers y comandos individuales
- **Integración** : JUnit5 + MockMvc. Puebas de controladores con repositorios mock
- **Funcionales**: Postman, verificaciones de endpoints REST con datos válidos
- **Validaciones**: Postman/JUnit Verificación de errores, campos obligatorios y entradas inválidas 

### 4️⃣ Escenarios de prueba

Profesor:

| Caso                   | Descripcion                         | Entrada                                             | Salida esperada                       | Resultado esperado                                       |
| ---------------------- | ----------------------------------- | --------------------------------------------------- | ------------------------------------- | -------------------------------------------------------- |
| `GET/profesor`         | Listar todos los profesores         | Ninguna                                             | HTTP 200,JSON con lista de profesores | Lista coincide con los datos de la base de datos H2      |
| `POST/profesor`        | Crear profesor válido               | `{ "nombre": "Paco", "apellidos": "Lopez" }`        | HTTP 201 Created con id asignado      | `{ profesor_id:1,"nombre":"Paco","apellidos":"Lopez" } ` |
| `POST/profesor`        | Crear profesor sin nombre/apellidos | `{ "nombre": "", "apellidos": "Lopez" }`            | HTTP 400, error de validación         | `{ "nombre": El campo nombre no puede estar vacío }`     |
| `PUT/profesor/{id}`    | Modificar profesor existente        | `{ "nombre": "Lucia","apellidos": "Pérez Gómez"  }` | HTTP 200, JSON con datos actualizados | `{ "nombre":"Cristina","apellidos":"Pérez Gómez"1 } `    |
| `PUT/profesor/{id}`    | Modificar profesor inexistente      | `{ "nombre": "Lucia","apellidos": "Pérez Gómez"  }` | HTTP 404                              | Devuelve error indicando que el profesor no existe       |
| `DELETE/profesor/{id}` | Eliminar profesor existente         | id válido                                           | HTTP204                               | El profesor se elimina de la base de datos H2            |
| `DELETE/profesor/{id}` | Eliminar profesor inexistente       | id inválido                                         | HTTP404                               | Devuelve error indicando que el profesor no existe       |

Alumnos:

| Caso                 | Descripción                         | Entrada                                                        | Salida esperada                         | Resultado esperado                                             |
| -------------------- | ----------------------------------- | -------------------------------------------------------------- | ---------------------------------------- | -------------------------------------------------------------- |
| `GET/alumnos`        | Listar todos los alumnos            | Ninguna                                                        | HTTP 200, JSON con lista de alumnos      | Lista coincide con los datos de la base de datos H2            |
| `POST/alumnos`       | Crear alumno válido                 | `{ "nombre": "Ana", "apellidos": "Ruiz", "profesorId": 1 }`    | HTTP 201 Created con id asignado         | `{ alumno_id:1,"nombre":"Ana","apellidos":"Ruiz","profesorId":1 }` |
| `POST/alumnos`       | Crear alumno sin nombre/apellidos   | `{ "nombre": "", "apellidos": "Ruiz", "profesorId": 1 }`       | HTTP 400, error de validación            | `{ "nombre": "El campo nombre no puede estar vacío" }`         |
| `PUT/alumnos/{id}`   | Modificar alumno existente          | `{ "nombre": "Lucia", "apellidos": "García", "profesorId": 2 }` | HTTP 200, JSON con datos actualizados    | `{ "nombre":"Lucia","apellidos":"García","profesorId":2 }`     |
| `PUT/alumnos/{id}`   | Modificar alumno inexistente        | `{ "nombre": "Lucia", "apellidos": "García", "profesorId": 2 }` | HTTP 404                                  | Devuelve error indicando que el alumno no existe               |
| `DELETE/alumnos/{id}`| Eliminar alumno existente           | id válido                                                      | HTTP 204                                 | El alumno se elimina de la base de datos H2                    |
| `DELETE/alumnos/{id}`| Eliminar alumno inexistente         | id inválido                                                    | HTTP 404                                 | Devuelve error indicando que el alumno no existe               |
