package reto;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Notification notifBasica = new Notification(
            "usuario@dominio.com",
            "sistema@app.com",
            "Bienvenida",
            "Gracias por registrarte."
        );
        notifBasica.send();

        Notification notifConAdjunto = new Notification(
            "admin@dominio.com",
            "alertas@app.com",
            "Alerta de Error Crítico",
            "Revisar el log de producción inmediatamente.",
            "CRITICAL",
            "error.log"
        );
        notifConAdjunto.send();

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