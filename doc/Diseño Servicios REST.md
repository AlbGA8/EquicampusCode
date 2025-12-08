### **Diseño de los servicios REST**
## 1️⃣ Alumnos

| Endpoint              | Petición HTTP | Body                                                            | Response Code  | Response Body                                                               | Posibles Errores                                           |
| --------------------- | ------------- | --------------------------------------------------------------- | -------------- | --------------------------------------------------------------------------- | ---------------------------------------------------------- |
| `/alumnos`            | GET           | N/A                                                             | 200 OK         | `{"alumnoId":1,"nombre":"Juan","apellidos":"Perez",profesor_id:1 }`         | 401 Unauthorized, 403 Forbidden, 500 Internal Server Error |
| `/alumnos`            | POST          | `{ "nombre": "Ana", "apellidos": "Lopez",profesor_id:1 }`       | 201 Created    | `{ "alumnoId":2,"nombre":"Ana","apellidos":"Lopez",profesor_id:1 } `        | 400 Bad Request, 401, 403, 500                             |
| `/alumnos/{alumnoId}` | GET           | N/A                                                             | 200 OK         | `{ "alumnoId":1,"nombre":"Juan","apellidos":"Perez",profesor_id:1 } `       | 401, 403, 404 Not Found, 500                               |
| `/alumnos/{alumnoId}` | PUT           | `{ "nombre": "Juan","apellidos": "Pérez Gómez" profesor_id:1 }` | 200 OK         | `{ "alumnoId":1,"nombre":"Juan","apellidos":"Pérez Gómez",profesor_id:1 } ` | 400, 401, 403, 404, 500                                    |
| `/alumnos/{alumnoId}` | DELETE        | N/A                                                             | 204 No Content | N/A                                                                         | 401, 403, 404, 500                                         |

## 2️⃣ Profesores

| Endpoint                 | Petición HTTP | Body                                                | Response Code  | Response Body                                                           | Posibles Errores                                           |
| ------------------------ | ------------- | --------------------------------------------------- | -------------- | ----------------------------------------------------------------------- | ---------------------------------------------------------- |
| `/profesor`              | GET           | N/A                                                 | 200 OK         | `{"profesor_id:,"nombre":"Miguel","apellidos":"Perez",profesor_id:1 }`  | 401 Unauthorized, 403 Forbidden, 500 Internal Server Error |
| `/profesor`              | POST          | `{ "nombre": "Paco", "apellidos": "Lopez" }`        | 201 Created    | `{ profesor_id:,"nombre":"Paco","apellidos":"Lopez",profesor_id:1 } `   | 400 Bad Request, 401, 403, 500                             |
| `/profesor/{ProfesorId}` | GET           | N/A                                                 | 200 OK         | `{ "profesor_id:,"nombre":"Lucia","apellidos":"Perez",profesor_id:1 } ` | 401, 403, 404 Not Found, 500                               |
| `/profesor/{ProfesorId}` | PUT           | `{ "nombre": "Lucia","apellidos": "Pérez Gómez"  }` | 200 OK         | `{ profesor_id:,"nombre":"Cristina","apellidos":"Pérez Gómez"1 } `      | 400, 401, 403, 404, 500                                    |
| `/profesor/{profesorId}` | DELETE        | N/A                                                 | 204 No Content | N/A                                                                     | 401, 403, 404, 500                                         |

