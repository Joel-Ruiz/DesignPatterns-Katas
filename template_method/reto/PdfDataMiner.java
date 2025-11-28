package template_method.reto;

public class PdfDataMiner {
    
    public void mine(String path) {
        // --- PASO 1: Abrir ---
        System.out.println("Abriendo archivo PDF en: " + path);
        
        // --- PASO 2: Extraer (Específico de PDF) ---
        System.out.println("Leyendo estructura binaria del PDF...");
        System.out.println("Extrayendo texto de las capas...");
        String data = "Datos PDF procesados";
        
        // --- PASO 3: Analizar (Común - ¡CÓDIGO DUPLICADO!) ---
        // El desarrollador copió y pegó la lógica de análisis aquí.
        System.out.println("Analizando los datos: " + data);
        System.out.println("Aplicando filtros de negocio...");
        
        // --- PASO 4: Cerrar ---
        System.out.println("Cerrando archivo PDF.");
    }
}