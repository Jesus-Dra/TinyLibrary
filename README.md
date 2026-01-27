# 📚 TinyLibrary API

TinyLibrary es una API REST desarrollada con **Java y Spring Boot** que simula un sistema básico de gestión de una biblioteca.  
El proyecto forma parte de mi proceso de aprendizaje y consolidación como **Backend Developer**, aplicando buenas prácticas de arquitectura, diseño de dominio y manejo de reglas de negocio.

---

## 🚀 Versión actual

### v0.4.0 – Book & Borrow domain completed

Versión en la que se completa el dominio principal de la aplicación, incorporando reglas de negocio reales y control total del ciclo de vida de los libros y préstamos.

**Incluye:**
- CRUD completo de **User**
- CRUD completo de **Book**
- Gestión de **Borrow (préstamos)** con lógica de negocio
- Control de estados mediante **Enums**
- Asignación de estados controlada exclusivamente desde el backend
- Validaciones y manejo de excepciones personalizadas
- Filtros para libros y préstamos según su estado

---

## 📌 Estado actual del proyecto

✔ Proyecto inicializado con Spring Boot  
✔ Arquitectura en capas (Controller, Service, Repository, DTO)  
✔ CRUD completo de usuarios  
✔ CRUD completo de libros  
✔ Sistema de préstamos con reglas de negocio  
✔ Manejo de excepciones con `@ControllerAdvice`  
✔ Persistencia con JPA / Hibernate  
✔ Control de versiones con Git  

---

## 🧠 Modelo de dominio

El sistema se compone de las siguientes entidades:

### 👤 User
Representa a los usuarios que pueden realizar préstamos.

### 📘 Book
Representa los libros disponibles en la biblioteca.  
Cada libro tiene **una única copia**, y su estado es controlado por el sistema.

**Estados posibles:**
- `AVAILABLE`
- `BORROWED`

### 🔁 Borrow
Entidad intermedia que gestiona los préstamos.

Incluye:
- Relación **Many-to-One** con User
- Relación **Many-to-One** con Book
- Fecha de préstamo
- Fecha de devolución
- Estado del préstamo

**Estados posibles:**
- `BORROWED`
- `RETURNED`

**Reglas clave:**
- Un libro no puede prestarse si ya está en estado `BORROWED`
- El estado del libro se actualiza automáticamente al prestar y devolver
- La fecha de devolución se asigna solo cuando el préstamo es retornado

---

## 🛠️ Tecnologías utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL / MySQL
- Maven
- Git & GitHub

---

## 🧱 Arquitectura

El proyecto sigue una **arquitectura en capas**:

- **Controller** – Exposición de endpoints REST
- **Service** – Lógica de negocio y reglas del dominio
- **Repository** – Acceso a datos con JPA
- **DTOs** – Separación entre modelo interno y datos expuestos
- **Enums** – Control de estados del dominio

---

## 🔍 Funcionalidades destacadas

- Creación automática de libros en estado `AVAILABLE`
- Préstamo de libros con validaciones de disponibilidad
- Devolución de libros con actualización de estado
- Filtros para:
  - Libros disponibles
  - Libros prestados
  - Préstamos activos
  - Préstamos devueltos
- Manejo centralizado de errores y respuestas HTTP

---

## 🧭 Próximos pasos

- Implementación de autenticación y autorización con **Spring Security + JWT**
- Asociación de préstamos al usuario autenticado
- Documentación de la API con **Swagger / OpenAPI**
- Tests unitarios y de integración
- Mejoras en validaciones y mensajes de error

---

## 👨‍💻 Autor

**Jesús Ramírez**  
Backend Developer – Java & Spring Boot  

Este proyecto se desarrolla de forma progresiva como parte de mi formación y crecimiento profesional como desarrollador backend.
