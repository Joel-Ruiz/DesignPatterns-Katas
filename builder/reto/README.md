# Reto (Builder)

## Instrucciones

El código en este directorio presenta la clase `Notification.java` que utiliza el Constructor Telescópico para manejar sus múltiples parámetros opcionales.
Tu objetivo es refactorizar esta implementación aplicando el Patrón Builder para lograr una construcción de objeto más legible, segura y mantenible.

## Codigo a refactorizar

**Archivo: `reto/Notification.java`**
```java
package reto;

import java.util.Date; 

public class Notification {
    
    private String recipient;
    private String sender;
    private String title;
    private String body;

    private String priority;
    private String attachment;
    private Date expirationDate;
    private boolean isHtml;

    public Notification(String recipient, String sender, String title, String body) {
        this(recipient, sender, title, body, null, null, null, false);
    }

    public Notification(String recipient, String sender, String title, String body, String priority) {
        this(recipient, sender, title, body, priority, null, null, false);
    }

    public Notification(String recipient, String sender, String title, String body, 
                        String priority, String attachment, Date expirationDate, boolean isHtml) {
        
        if (recipient == null || sender == null || title == null || body == null) {
            throw new IllegalArgumentException("Recipient, sender, title, and body must be provided.");
        }
        
        this.recipient = recipient;
        this.sender = sender;
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.attachment = attachment;
        this.expirationDate = expirationDate;
        this.isHtml = isHtml;
    }

    public void send() {
        // ... (Implementación del método send)
    }
}
```

**Archivo: `Main.java`**
```java
package reto;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        // 1. Notificación básica
        Notification notifBasica = new Notification(
            "usuario@dominio.com",
            "sistema@app.com",
            "Bienvenida",
            "Gracias por registrarte."
        );
        notifBasica.send();

        // 2. Notificación con prioridad y adjunto (Uso incómodo)
        Notification notifConAdjunto = new Notification(
            "admin@dominio.com",
            "alertas@app.com",
            "Alerta de Error Crítico",
            "Revisar el log de producción inmediatamente.",
            "CRITICAL",
            "error.log"
        );
        notifConAdjunto.send();
        
        // 3. Notificación con todas las opciones
        Notification notifCompleta = new Notification(
            "jefe@dominio.com",
            "reportes@app.com",
            "Reporte Mensual",
            "Adjunto el resumen de actividades.",
            "HIGH", 
            "reporte.pdf", 
            new Date(System.currentTimeMillis() + 86400000), // Mañana
            true
        );
        notifCompleta.send();
    }
}
```

## Tips

1. Principios SOLID
    - ¿Cómo garantiza el Principio de Responsabilidad Única (SRP) esta refactorización? ¿Qué responsabilidad se le quitó a la clase Notification y se le dio al NotificationBuilder?
    - Concepto Clave: El Builder Pattern aplica el SRP al separar la responsabilidad de construcción (Builder) de la responsabilidad de dominio (Producto).
2. Inmutabilidad y Encapsulación
    - ¿Por qué es fundamental que el constructor de Notification sea privado después de aplicar el patrón? ¿Cómo ayuda esto a la inmutabilidad del objeto final?
    - Técnica: Asegúrate de que los campos de la clase Notification sean declarados como final para forzar la inmutabilidad una vez que el objeto ha sido construido por el Builder.

## Recursos Adicionales

[Refactoring Guru - Builder Pattern](https://refactoring.guru/design-patterns/builder)
[Source Making - Builder Pattern](https://sourcemaking.com/design_patterns/builder)