# Arquitectura Tecnica

## Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- MapStruct
- Flyway
- Springdoc OpenAPI

## Estructura de paquetes

- controller
- service
- repository
- dto
- mapper
- exception
- entity
- config

## Modelo de datos base

Lead
- id
- firstName
- lastName
- email
- phone
- companyName
- source
- status
- notes
- createdAt
- isDeleted (si se adopta soft delete)

Contact
- id
- firstName
- lastName
- email
- phone
- company (ManyToOne)
- createdAt

Company
- id
- name
- industry
- website
- createdAt

## Convenciones tecnicas

- snake_case en base de datos.
- camelCase en Java.
- Paginacion por defecto: page=0, size=20, sort=createdAt,desc.
- size maximo recomendado: 100.

## Errores

Formato uniforme:
- timestamp
- status
- error
- message
- path
- code

Codigos de negocio minimos:
- LEAD_NOT_FOUND
- LEAD_ALREADY_CONVERTED
- LEAD_EDIT_FORBIDDEN_CONVERTED
- LEAD_DELETE_FORBIDDEN_CONVERTED
- CONTACT_EMAIL_DUPLICATE
- VALIDATION_ERROR
