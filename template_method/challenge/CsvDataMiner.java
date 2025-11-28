package template_method.challenge;

public class CsvDataMiner {
    
    public void mine(String path) {
        // --- PASO 1: Abrir ---
        System.out.println("Abriendo archivo CSV en: " + path);
        
        // --- PASO 2: Extraer (Específico de CSV) ---
        System.out.println("Leyendo líneas del CSV...");
        System.out.println("Parseando campos separados por comas...");
        String data = "Datos CSV procesados";
        
        // --- PASO 3: Analizar (Común) ---
        // Imagina que esto son 50 líneas de lógica de negocio compleja
        System.out.println("Analizando los datos: " + data);
        System.out.println("Aplicando filtros de negocio...");
        
        // --- PASO 4: Cerrar ---
        System.out.println("Cerrando archivo CSV.");
    }
}