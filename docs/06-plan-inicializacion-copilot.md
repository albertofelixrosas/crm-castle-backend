# Plan de Inicializacion con GitHub Copilot

## Objetivo de esta fase

Inicializar el proyecto base sin implementar aun toda la logica final, dejando una estructura robusta para iterar.

## Entregables de inicializacion

1. Proyecto Maven Spring Boot con dependencias requeridas.
2. Estructura de paquetes por capas.
3. Entidades y enums iniciales.
4. Repositories base.
5. DTOs base y mappers base.
6. Esqueleto de services y controllers.
7. Global exception handler base.
8. application.yml con perfiles dev/test/prod.
9. Flyway con migracion inicial V1.
10. Swagger habilitado.
11. Coleccion Postman inicial y archivo .http inicial.

## Orden sugerido de trabajo

1. Crear proyecto y dependencias.
2. Configurar persistencia y Flyway.
3. Crear entidades y repositorios.
4. Crear DTOs y mappers.
5. Crear services y controllers.
6. Implementar manejo de errores.
7. Agregar documentacion y ejemplos.
8. Agregar pruebas minimas.

## Criterios de aceptacion de fase

- El proyecto compila.
- La app levanta contra PostgreSQL local.
- Endpoints base responden.
- Migraciones aplican correctamente.
- Swagger y pruebas basicas funcionan.
