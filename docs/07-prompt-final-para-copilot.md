# Prompt Final para Inicializar el Proyecto

Quiero que inicialices un backend profesional API REST en Java 21 con Spring Boot para un mini CRM inspirado en Salesforce.

Objetivo de negocio:
- Modelar un flujo Lead -> Conversion -> Contact + Company.

Stack obligatorio:
- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Lombok
- Jakarta Validation
- MapStruct
- Flyway
- OpenAPI/Swagger

Arquitectura:
- Paquetes por capas: controller, service, repository, dto, mapper, exception, entity, config
- DTOs separados de entidades
- ResponseEntity y codigos HTTP correctos
- Manejo global de excepciones con ControllerAdvice

Reglas de negocio:
- La conversion se ejecuta en transaccion.
- Se puede convertir un Lead desde cualquier estado excepto CONVERTED.
- Al convertir, se crea o reutiliza Company por nombre normalizado.
- Se crea Contact asociado a Company.
- Lead queda en status CONVERTED.
- Lead convertido no se edita en flujo normal.
- Lead.email no es unico obligatorio.
- Contact.email es unico.

Endpoints requeridos:
- Leads: crear, listar paginado, obtener por id, actualizar, eliminar, filtrar por status, convertir.
- Contacts: listar paginado, obtener por id.
- Companies: listar paginado, obtener por id.

Convenciones:
- Base path: /api/v1
- Paginacion por defecto: size 20
- Orden por defecto: createdAt desc
- Max size: 100
- DB naming en snake_case

Errores:
Formato unico con campos timestamp, status, error, message, path, code.
Incluir codigos de negocio como LEAD_NOT_FOUND y LEAD_ALREADY_CONVERTED.

Entregables de esta fase de inicializacion:
1. Estructura completa del proyecto.
2. Dependencias y configuraciones.
3. Esqueletos de entidades, repositorios, servicios, controladores, DTOs y mappers.
4. application.yml con perfiles dev/test/prod.
5. Migracion Flyway inicial.
6. Swagger habilitado.
7. Coleccion Postman inicial y archivo .http inicial.
8. Instrucciones para ejecutar con PostgreSQL local.

Criterio final:
Debe sentirse como backend real de portafolio junior/intermedio, limpio, consistente y listo para evolucionar en siguientes iteraciones.
