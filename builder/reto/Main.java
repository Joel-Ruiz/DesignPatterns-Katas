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
        // Se debe recordar qué parámetro corresponde a qué posición (null, null, ...)
        Notification notifConAdjunto = new Notification(
            "admin@dominio.com",
            "alertas@app.com",
            "Alerta de Error Crítico",
            "Revisar el log de producción inmediatamente.",
            "CRITICAL", // priority
            "error.log"  // attachment
            // El resto de parámetros (expirationDate, isHtml) deben omitirse
            // o pasarse como null/false para usar el constructor adecuado.
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