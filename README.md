# 📚 TinyLibrary API

TinyLibrary es una API REST desarrollada con **Spring Boot** que simula un sistema básico de gestión de biblioteca.  
Incluye autenticación con **JWT**, seguridad con **Spring Security**, manejo de préstamos de libros y persistencia con base de datos relacional.

Este proyecto forma parte de mi proceso de aprendizaje y consolidación como **Backend Developer (Java / Spring Boot)**.

---

## 📌 Versión actual
**v0.5.0**

### ¿Qué incluye esta versión?
- Autenticación con JWT
- Seguridad stateless con Spring Security
- Hashing de contraseñas con BCrypt
- Endpoints protegidos por token
- CRUDs completos
- Arquitectura en capas
- Manejo de excepciones personalizado

---

## 🧱 Estado actual del proyecto

### ✅ Funcionalidades implementadas

#### 🔐 Autenticación y Seguridad
- Login mediante email y contraseña
- Generación de JWT firmado (HS256)
- Filtro de autenticación personalizado (`OncePerRequestFilter`)
- Validación de token en cada request
- Seguridad Stateless
- Passwords hasheados con BCrypt

#### 📚 Libros (Book)
- Crear libro (estado inicial `AVAILABLE`)
- Listar libros
- Filtrar libros disponibles / prestados
- Control de estado (`AVAILABLE / BORROWED`)

#### 🔄 Préstamos (Borrow)
- Registrar préstamo de libro
- Devolver libro
- Ver préstamos activos
- Relación User ↔ Book
- Control de estados (`BORROWED / RETURNED`)

#### 👤 Usuarios (User)
- Creación de usuarios
- Validación de email único
- Contraseñas encriptadas
- Relación con préstamos

---

## 🧠 Modelo de dominio

### User
- id
- name
- age
- correo (único)
- password (BCrypt)
- préstamos

### Book
- id
- name
- editorial
- agebook
- status (`AVAILABLE / BORROWED`)

### Borrow
- id
- user
- book
- borrowDate
- returnDate
- status (`BORROWED / RETURNED`)

---

## 🏗️ Arquitectura

Arquitectura en capas:

- **Controller** → manejo de endpoints HTTP
- **Service** → lógica de negocio
- **Repository** → acceso a datos (JPA)
- **DTOs** → separación entidad / respuesta
- **Security** → JWT, filtros y configuración
- **Exception** → manejo centralizado de errores

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Security
- Spring Web
- Spring Data JPA
- JWT (jjwt)
- BCrypt
- MySQL / PostgreSQL
- Maven
- Git

---

## 🔐 Seguridad (detalle técnico)

- Autenticación basada en **JWT**
- Tokens firmados con clave secreta
- Filtro personalizado que:
  - Extrae token del header `Authorization`
  - Valida firma y expiración
  - Carga usuario en el `SecurityContext`
- Endpoints protegidos por configuración de `SecurityFilterChain`

---

## 🚀 Próximos pasos (Roadmap)

- Implementar roles (`ADMIN / USER`)
- Documentación con Swagger / OpenAPI
- Tests unitarios
- Refresh Token
- Dockerización
- Manejo avanzado de permisos

---

## 👤 Autor

**Jesús Ramírez**  
Backend Developer — Java & Spring Boot  

Proyecto desarrollado como parte de mi formación continua y práctica profesional.
