# Contrato API REST

## Base path

/api/v1

## Leads

- POST /leads
- GET /leads
- GET /leads/{id}
- PUT /leads/{id}
- DELETE /leads/{id}
- GET /leads/status/{status}
- GET /leads/search?email=&companyName=&source=&createdAtFrom=&createdAtTo=
- POST /leads/{id}/convert

## Contacts

- GET /contacts
- GET /contacts/{id}

## Companies

- GET /companies
- GET /companies/{id}

## Codigos HTTP esperados

- 200 OK: lecturas y conversion exitosa.
- 201 Created: creacion de recursos.
- 204 No Content: borrado exitoso (si aplica).
- 400 Bad Request: validaciones.
- 404 Not Found: recurso inexistente.
- 409 Conflict: reglas de negocio (ej: lead ya convertido).

## Ejemplo de error

{
  "timestamp": "2026-05-07T12:00:00",
  "status": 409,
  "error": "Conflict",
  "message": "Lead already converted",
  "path": "/api/v1/leads/10/convert",
  "code": "LEAD_ALREADY_CONVERTED"
}
