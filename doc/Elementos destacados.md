### ⭐Elementos destacables del desarrollo

Durante el desarrollo se identificó un problema importante y la forma en que se resolvió:

- **Desacoplamiento de las pruebas con la base de datos real:**  
    Inicialmente, las pruebas JUnit intentaban acceder a la base de datos H2, aunque se estaban utilizando factorías (_AlumnoFactory_, _ProfesorFactory_) y repositorios mock. Esto provocaba errores en los tests de integración, ya que los datos esperados no coincidían con los presentes en la base de datos.
    
- **Solución aplicada:**  
    Para resolverlo, se ajustó la configuración de los repositorios mock y se simplificó la prueba del GET, verificando directamente que los endpoints devolvían los datos correctos sin depender de la base de datos H2.
    
- **Beneficio de la arquitectura Hexagonal:**  
    La separación entre dominio, aplicación e infraestructura permitió aislar los servicios de acceso a datos, facilitando la corrección del problema y permitiendo pruebas más confiables.
    
- **Uso efectivo de IoC y DI:**  
    La inyección de dependencias de Spring permitió sustituir fácilmente los repositorios reales por implementaciones mock, mejorando la mantenibilidad y la testabilidad del sistema.


  ![alt text](/imagenes/pruebasBien.png)