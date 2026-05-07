# Requisitos Funcionales y No Funcionales

## Funcionales

### Leads
- Crear lead.
- Obtener todos los leads (paginado).
- Obtener lead por id.
- Actualizar lead.
- Eliminar lead (soft o hard segun decision final).
- Filtrar por status.
- Buscar por email, companyName, source y rango de fecha de creacion.

### Conversion
Endpoint: POST /api/v1/leads/{id}/convert

Flujo:
1. Buscar lead por id.
2. Validar que no este convertido.
3. Crear o reutilizar company.
4. Crear contact asociado.
5. Marcar lead como CONVERTED.
6. Responder ids de lead/contact/company.

### Contacts
- Listar contactos (paginado).
- Obtener contacto por id.

### Companies
- Listar companies (paginado).
- Obtener company por id.

## No funcionales

- Java 21.
- Spring Boot 3.x.
- API REST JSON.
- Arquitectura por capas.
- DTOs separados de entidades.
- Validaciones con Jakarta Validation.
- Manejo global de excepciones con ControllerAdvice.
- Persistencia con PostgreSQL y JPA/Hibernate.
- Migraciones con Flyway.
- Codigo limpio y mantenible.
- Documentacion OpenAPI/Swagger.
- Tests minimos de service y controller.
