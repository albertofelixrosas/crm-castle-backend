# CRM Castle Backend

Mini CRM API REST con Java 21 y Spring Boot, inspirado en el flujo de conversion de Leads de Salesforce.

## Stack

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA + Hibernate
- PostgreSQL
- Flyway
- MapStruct
- Lombok
- OpenAPI/Swagger

## Estructura

- src/main/java/com/crmcastle/backend/controller
- src/main/java/com/crmcastle/backend/service
- src/main/java/com/crmcastle/backend/repository
- src/main/java/com/crmcastle/backend/dto
- src/main/java/com/crmcastle/backend/mapper
- src/main/java/com/crmcastle/backend/exception
- src/main/java/com/crmcastle/backend/entity
- src/main/java/com/crmcastle/backend/config

## Configuracion de base de datos local

1. Crear base de datos:
   - crm_castle
2. Crear usuario y password (o usar postgres/postgres).
3. Ajustar credenciales en src/main/resources/application-dev.yml.

## Ejecutar

1. Compilar:
   - mvn clean install
2. Ejecutar:
   - mvn spring-boot:run
3. Ejecutar pruebas:
   - mvn test
3. Swagger:
   - http://localhost:8080/swagger-ui.html

## Pruebas y perfil test

- Los tests de Spring Boot usan el perfil `test`.
- El perfil test esta configurado con H2 en memoria para no depender de PostgreSQL local.

## Endpoints principales

- POST /api/v1/leads
- GET /api/v1/leads
- GET /api/v1/leads/{id}
- PUT /api/v1/leads/{id}
- DELETE /api/v1/leads/{id}
- GET /api/v1/leads/status/{status}
- POST /api/v1/leads/{id}/convert
- GET /api/v1/contacts
- GET /api/v1/contacts/{id}
- GET /api/v1/companies
- GET /api/v1/companies/{id}

## Artefactos de prueba

- Coleccion Postman: postman/crm-castle-api.postman_collection.json
- Archivo HTTP: crm-castle.http
