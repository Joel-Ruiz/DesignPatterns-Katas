public class Main {
    public static void main(String[] args) {
        
        // Uso limpio y legible
        Notification email = new Notification.NotificationBuilder(
                "user@example.com", 
                "admin@app.com", 
                "Bienvenida", 
                "Hola mundo"
            )
            .withPriority("HIGH")
            .asHtml()
            .build(); // ¡Construir!

        email.send();
    }
}