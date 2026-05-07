# Reglas de Negocio Salesforce-Inspired

## Principios base

- La conversion de Lead es una accion de negocio dedicada, no solo un cambio manual de status.
- Un Lead convertido pasa a estado CONVERTED.
- El comportamiento debe minimizar duplicados al convertir.

## Reglas acordadas

1. Company por nombre:
- Reutilizar Company existente por nombre normalizado (trim + lower).

2. Unicidad de email:
- Lead.email: no unico global obligatorio.
- Contact.email: unico global recomendado para este proyecto.

3. Elegibilidad de conversion:
- Se puede convertir desde cualquier estado excepto CONVERTED.

4. Estado post-conversion:
- Lead convertido no debe poder editarse en flujo normal.
- Eliminacion de lead convertido se decide por politica de borrado (ver requisitos).

5. Conversion transaccional:
- La conversion debe ejecutarse con transaccion unica.
- Si falla un paso, se revierte todo.

## Regla sugerida sobre borrado

Para parecerse mas a Salesforce:
- Preferir soft delete en Lead.

Alternativa de simplificacion:
- Hard delete, documentado explicitamente.
