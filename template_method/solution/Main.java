
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Reporte Unificado de Minería de Datos ---");

        // 1. Procesamiento de un CSV
        // Nota: Es buena práctica declarar la variable con el tipo de la clase abstracta
        DataMiner csvMiner = new CsvDataMiner();
        
        System.out.println("\n[Procesando Archivo CSV]");
        // Llamamos al Template Method (definido en la clase padre)
        csvMiner.mine("/ruta/a/clientes.csv");

        // 2. Procesamiento de un PDF
        DataMiner pdfMiner = new PdfDataMiner();
        
        System.out.println("\n[Procesando Archivo PDF]");
        // El cliente no sabe los detalles internos, solo ejecuta la minería
        pdfMiner.mine("/ruta/a/nomina.pdf");
        
        System.out.println("\n");

        // 3. (Opcional) Demostración de Polimorfismo
        // Podríamos tener una lista de mineros y procesarlos en bucle
        List<DataMiner> miners = List.of(new CsvDataMiner(), new PdfDataMiner());
        miners.forEach(m -> m.mine("archivo_genérico"));
    }
}