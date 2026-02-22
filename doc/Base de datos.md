# 📘 Migración de H2 a MySQL

## 🟢 Contexto

Inicialmente el proyecto utilizaba:

- **H2 Database** → Base de datos en memoria, útil para desarrollo y pruebas rápidas.

Ahora se migra a:

- **MySQL** → Base de datos persistente, más adecuada para entornos productivos.

### ✅ Beneficios de la migración
- Persistencia real de datos.
- Mejor control del almacenamiento.
- Arquitectura más cercana a producción.

---

## 🟢 Dependencias necesarias

### Maven
```xml
	<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency> 
  
  ```
---
## Configuración de conexión a MySQL
### application.properties
```properties
# Logging SQL
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG

# Conexión a la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/store_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🟢 Gestión de schema.sql

### 📌 Uso anterior
En entornos de desarrollo con H2 se utilizaban habitualmente los siguientes archivos:

- `schema.sql`
- `data.sql`

Estos archivos permitían inicializar la estructura y los datos de prueba de forma automática.

---

### 📌 Uso con MySQL en producción

❌ Se recomienda eliminar el archivo:

- `schema.sql`

### ✅ Motivo
La estructura de la base de datos debe gestionarse mediante herramientas de migración versionadas, garantizando:

- Mayor control de cambios.
- Mejor trazabilidad de versiones.
- Evitar modificaciones automáticas no controladas en la base de datos.