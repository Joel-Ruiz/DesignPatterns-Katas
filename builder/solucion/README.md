# Solución (Builder)

:warning: **Intenta resolver el reto antes de ver la solución** :warning:

## Cambios Principales

1. Clase Notification (El Producto):
    - Se eliminaron todos los constructores públicos y sobrecargados.
    - Se hizo el constructor principal privado para asegurar que solo pueda ser llamado desde dentro de la clase (específicamente por el Builder).
    - Se asignaron los valores de los atributos directamente en el constructor privado, recibiendo la instancia de NotificationBuilder o los valores finales.
2. Clase NotificationBuilder (El Constructor):
    - Se creó una clase estática anidada (public static class NotificationBuilder) dentro de Notification.
    - Se definieron métodos públicos y fluidos (que devuelven this) para establecer cada parámetro opcional (ej. withPriority(), withAttachment()).
    - Se implementó el método build(), el cual crea una instancia de Notification usando el constructor privado y devuelve el objeto final.
3. Uso en Main.java (El Cliente):
    - Las llamadas al constructor fueron reemplazadas por el uso del Builder, logrando una sintaxis de encadenamiento de métodos que es clara y expresiva.

## Salida Esperada

```
--- Enviando Notificación ---
- Para: usuario@dominio.com
- De: sistema@app.com
- Título: Bienvenida
Contenido (Texto Simple):
Gracias por registrarte.
----------------------------

--- Enviando Notificación ---
- Para: admin@dominio.com
- De: alertas@app.com
- Título: Alerta de Error Crítico
- Prioridad: CRITICAL
- Adjunto: error.log
Contenido (Texto Simple):
Revisar el log de producción inmediatamente.
----------------------------

--- Enviando Notificación ---
- Para: jefe@dominio.com
- De: reportes@app.com
- Título: Reporte Mensual
- Prioridad: HIGH
- Adjunto: reporte.pdf
- Expira: Fri Nov 22 01:20:03 CST 2025 // La fecha real puede variar
Contenido (HTML):
Adjunto el resumen de actividades.
----------------------------
```

Con la solución aplicada, agregar nuevos campos a la clase `Notification` solo requiere:
1. Añadir el campo a `NotificationBuilder`
2. Crear uun método en el Builder
3. Añadir el nuevo campo al constructor de `Notification`

Además, es posible añadir nuevas clases Director para añadir nuevas notificaciones preconfiguradas. 