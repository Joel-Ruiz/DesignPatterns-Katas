package template_method.challenge;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Minería de Datos CSV ---");
        CsvDataMiner csvMiner = new CsvDataMiner();
        csvMiner.mine("datos.csv");
        
        System.out.println("\n--- Minería de Datos PDF ---");
        PdfDataMiner pdfMiner = new PdfDataMiner();
        pdfMiner.mine("informe.pdf");
        
        // El cliente no tiene una forma uniforme de tratarlos (no comparten clase padre útil)
        // Y si cambiamos la lógica de "Analizar", tenemos que editar las dos clases.
    }
}