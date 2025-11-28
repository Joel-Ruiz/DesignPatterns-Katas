package challenge;

import java.util.Date; 

public class Notification {
    
    // Parámetros obligatorios
    private String recipient;
    private String sender;
    private String title;
    private String body;

    // Parámetros opcionales
    private String priority;
    private String attachment;
    private Date expirationDate;
    private boolean isHtml;

    // --- CONSTRUCTORES TELESCÓPICOS (El problema) ---

    // 1. Constructor básico
    public Notification(String recipient, String sender, String title, String body) {
        this(recipient, sender, title, body, null, null, null, false);
    }
    
    // 2. Constructor con prioridad
    public Notification(String recipient, String sender, String title, String body, String priority) {
        this(recipient, sender, title, body, priority, null, null, false);
    }

    // 3. Constructor con prioridad y adjunto
    public Notification(String recipient, String sender, String title, String body, String priority, String attachment) {
        this(recipient, sender, title, body, priority, attachment, null, false);
    }

    // 4. Constructor con todos los parámetros (Constructor Maestro)
    public Notification(String recipient, String sender, String title, String body, 
                        String priority, String attachment, Date expirationDate, boolean isHtml) {
        
        // Validación básica
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

    // Método para simular el envío
    public void send() {
        System.out.println("--- Enviando Notificación ---");
        System.out.println("Para: " + recipient);
        System.out.println("De: " + sender);
        System.out.println("Título: " + title);
        
        if (priority != null) {
            System.out.println("Prioridad: " + priority);
        }
        if (attachment != null) {
            System.out.println("Adjunto: " + attachment);
        }
        if (expirationDate != null) {
            System.out.println("Expira: " + expirationDate);
        }
        
        System.out.println("Contenido (" + (isHtml ? "HTML" : "Texto Simple") + "):\n" + body);
        System.out.println("----------------------------\n");
    }
}