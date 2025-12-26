# 📚 TinyLibrary API

**TinyLibrary** es una API REST desarrollada con **Java y Spring Boot** que simula un sistema básico de biblioteca, permitiendo la gestión de usuarios, libros y préstamos.

Este proyecto forma parte de mi proceso de aprendizaje y consolidación como **Backend Developer**, aplicando buenas prácticas de arquitectura, persistencia y control de relaciones entre entidades.

---

## 🚀 Versión actual

**v0.0.1 – Initial Setup**

> Primera versión funcional del proyecto, enfocada en la definición del dominio y la persistencia de datos.

---

## 🧱 Estado actual del proyecto

✔ Proyecto inicializado con Spring Boot  
✔ Conexión configurada a PostgreSQL  
✔ Entidades principales creadas  
✔ Relaciones entre entidades definidas mediante JPA  
✔ Repositorio subido y versionado en GitHub  

---

## 🧩 Modelo de dominio

El sistema se compone de las siguientes entidades:

### 👤 User
Representa a los usuarios que pueden solicitar libros.

### 📖 Book
Representa los libros disponibles en la biblioteca.

### 🔄 Borrow
Entidad intermedia que gestiona los préstamos:
- Relación **Many-to-One** con `User`
- Relación **Many-to-One** con `Book`
- Fecha de préstamo
- Fecha de devolución
- Estado del préstamo

Esto permite que:
- Un usuario pueda tener varios préstamos
- Un libro pueda ser prestado múltiples veces (en distintos momentos)

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **Git & GitHub**

---

## 🗂️ Arquitectura (en progreso)

El proyecto sigue una arquitectura en capas:

- `entity` → Modelo de datos
- `repository` → Acceso a datos *(próximo paso)*
- `service` → Lógica de negocio *(próximo paso)*
- `controller` → API REST *(próximo paso)*

---

## 🔜 Próximos pasos

- Creación de repositories
- Implementación de servicios
- Exposición de endpoints REST
- Manejo de excepciones globales
- Seguridad con **Spring Security + JWT**
- Documentación con **Swagger/OpenAPI**
- Tests unitarios

---

## 👨‍💻 Autor

**Jesús Ramírez**  
Backend Developer – Java & Spring Boot  

---

> Este proyecto se irá actualizando de forma progresiva conforme avance su desarrollo 🚀
