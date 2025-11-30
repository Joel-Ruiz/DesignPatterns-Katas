import java.util.Date;

public class Notification {
    
    // Todos los atributos son finales (Inmutabilidad)
    private final String recipient;
    private final String sender;
    private final String title;
    private final String body;
    private final String priority;
    private final String attachment;
    private final Date expirationDate;
    private final boolean isHtml;

    // Constructor PRIVADO: Solo el Builder puede llamar a esto
    private Notification(NotificationBuilder builder) {
        this.recipient = builder.recipient;
        this.sender = builder.sender;
        this.title = builder.title;
        this.body = builder.body;
        this.priority = builder.priority;
        this.attachment = builder.attachment;
        this.expirationDate = builder.expirationDate;
        this.isHtml = builder.isHtml;
    }

    // Getters (sin Setters para mantener inmutabilidad)
    public String getRecipient() { return recipient; }
    public String getSender() { return sender; }
    // ... (puedes generar el resto de getters con tu IDE)

    public void send() {
        System.out.println("--- Enviando Notificación (Builder) ---");
        System.out.println("Para: " + recipient + " | De: " + sender);
        System.out.println("Título: " + title);
        if(priority != null) System.out.println("Prioridad: " + priority);
        if(attachment != null) System.out.println("Adjunto: " + attachment);
        System.out.println("Contenido: " + body);
        System.out.println("--------------------------------------\n");
    }

    // --- CLASE BUILDER (Static Inner Class) ---
    public static class NotificationBuilder {
        // Obligatorios
        private final String recipient;
        private final String sender;
        private final String title;
        private final String body;

        // Opcionales (con valores por defecto si se desea)
        private String priority;
        private String attachment;
        private Date expirationDate;
        private boolean isHtml;

        // El constructor del Builder recibe solo lo obligatorio
        public NotificationBuilder(String recipient, String sender, String title, String body) {
            this.recipient = recipient;
            this.sender = sender;
            this.title = title;
            this.body = body;
        }

        // Métodos "Fluent" para los opcionales
        public NotificationBuilder withPriority(String priority) {
            this.priority = priority;
            return this; // Retornamos 'this' para encadenar
        }

        public NotificationBuilder withAttachment(String attachment) {
            this.attachment = attachment;
            return this;
        }

        public NotificationBuilder expiresAt(Date date) {
            this.expirationDate = date;
            return this;
        }

        public NotificationBuilder asHtml() {
            this.isHtml = true;
            return this;
        }

        // Método final que construye el objeto
        public Notification build() {
            return new Notification(this);
        }
    }
}