# 📚 TinyLibrary API

TinyLibrary es una **API REST desarrollada con Spring Boot** que simula la gestión de una biblioteca digital.  
El proyecto implementa **autenticación JWT**, **roles (USER / ADMIN)**, control de accesos, seguridad avanzada y una arquitectura limpia basada en buenas prácticas.

Este proyecto fue creado con fines **educativos y profesionales**, demostrando el flujo completo de autenticación, autorización y gestión de recursos en un backend moderno.

---

## 🚀 Versión actual

**v1.0.0**

> Proyecto funcional y estable, con seguridad basada en JWT y control de roles.

---

## ✅ Funcionalidades implementadas

### 🔐 Autenticación y Seguridad
- Login con **JWT**
- Tokens firmados con **HS256**
- Contraseñas **hasheadas con BCrypt**
- **Roles de usuario**:
    - `ROLE_USER`
    - `ROLE_ADMIN`
- Asignación automática del **primer usuario como ADMIN**
- Filtros de seguridad personalizados (`OncePerRequestFilter`)
- Control de acceso por endpoint y método HTTP
- Manejo de errores de seguridad:
    - `401 Unauthorized` → Usuario no autenticado
    - `403 Forbidden` → Usuario sin permisos
- **Mensajes de error personalizados** (JSON)

---

### 👤 Usuarios
- Crear usuarios
- Validación de correo duplicado
- Obtener perfil del usuario autenticado (`/me`)
- Obtener lista de usuarios (**solo ADMIN**)

---

### 📖 Libros
- Crear libros (**ADMIN**)
- Listar libros (**USER / ADMIN**)
- Actualizar libros (**ADMIN**)
- Eliminar libros (**ADMIN**)

---

### 🔄 Préstamos (Borrow)
- Registrar préstamo (**ADMIN**)
- Listar préstamos (**ADMIN**)
- Control de estado:
    - BORROWED
    - RETURNED

---

## 🧱 Modelo de dominio

### User
- id
- name
- age
- correo (email)
- password (BCrypt)
- roleUser (ENUM)

### Book
- id
- title
- author
- available

### Borrow
- id
- user
- book
- borrowDate
- returnDate
- status

---

## 🏗️ Arquitectura

- Controllers (REST)
- Services (lógica de negocio)
- Repositories (JPA / Hibernate)
- DTOs (Request / Response)
- Security Layer:
    - JWT Filter
    - SecurityConfig
    - CustomAccessDeniedHandler
    - CustomAuthenticationEntryPoint
- Manejo global de excepciones
- Separación clara de responsabilidades

---

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.x
- Spring Security
- Spring Data JPA
- JWT (jjwt)
- BCrypt
- PostgreSQL
- Maven
- Postman (testing manual de endpoints)

---

## 🔒 Seguridad (detalles técnicos)

- Autenticación Stateless
- Tokens enviados por header:
- Filtros personalizados para validar:
- Token
- Usuario
- Rol
- Control fino por endpoint y método HTTP
- Handlers personalizados para respuestas 401 y 403

---

## 🧪 Testing (Roadmap)

- Implementar **tests unitarios**
- Uso de:
- JUnit 5
- Mockito
- Tests planeados:
- Servicios
- Seguridad
- Validaciones
- Excepciones

---

## 📌 Próximas mejoras

- Tests unitarios con Mockito
- Paginación y filtros
- Refresh Token
- Dockerización
- Deploy (Railway / Render / AWS)

---

## 👨‍💻 Autor

**Jesús Ramírez**  
Backend Developer (Java · Spring Boot)

Proyecto desarrollado como parte de formación práctica y preparación profesional.