# 📚 TinyLibrary API

TinyLibrary es una API REST desarrollada con Java y Spring Boot que simula un
sistema básico de biblioteca, permitiendo la gestión de usuarios y libros.

Este proyecto forma parte de mi proceso de aprendizaje y consolidación como
Backend Developer, aplicando buenas prácticas de arquitectura, persistencia
y control de excepciones.

---

## 🚀 Versión actual

**v0.2.0 – User & Book CRUD implemented**

La API cuenta con los módulos **User** y **Book** completamente implementados,
incluyendo validaciones de negocio, manejo de excepciones personalizadas
y arquitectura en capas.

---

## 📌 Estado actual del proyecto

✔️ Proyecto inicializado con Spring Boot  
✔️ CRUD completo para **User**  
✔️ CRUD completo para **Book**  
✔️ Validaciones de negocio (campos únicos, datos obligatorios)  
✔️ Manejo de excepciones personalizadas con `@RestControllerAdvice`  
✔️ Arquitectura en capas (Controller, Service, Repository, DTO)  
✔️ Repositorio versionado en GitHub  

---

## 🧠 Modelo de dominio

El sistema se compone de las siguientes entidades:

### 👤 User
Representa a los usuarios que pueden solicitar préstamos.

### 📘 Book
Representa los libros disponibles en la biblioteca.
Cada libro tiene una única copia y puede estar disponible o prestado.

### 🔁 Borrow *(en progreso)*
Entidad encargada de gestionar los préstamos:
- Relación **Many-to-One** con User  
- Relación **Many-to-One** con Book  
- Fecha de préstamo  
- Fecha de devolución  
- Estado del préstamo  

Esto permite:
- Que un usuario pueda tener varios préstamos
- Que un libro tenga historial de préstamos (uno activo a la vez)

---

## 🛠️ Tecnologías utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Git & GitHub

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

- **Controller** – Manejo de solicitudes HTTP (API REST)
- **Service** – Lógica de negocio
- **Repository** – Acceso a datos con JPA
- **DTO** – Transferencia de datos entre capas
- **Exception** – Manejo centralizado de errores

---

## 🔜 Próximos pasos

- Implementar módulo **Borrow**
- Implementar relaciones entre entidades
- Autenticación y autorización con **Spring Security + JWT**
- Seguridad basada en roles
- Documentación con **Swagger / OpenAPI**
- Tests unitarios

---

## 👤 Autor

**Jesus Ramirez**  
Backend Developer – Java & Spring Boot  

Este proyecto se desarrolla de forma progresiva como parte de mi formación
como desarrollador backend.
