public class PdfDataMiner extends DataMiner {

    @Override
    protected void openFile(String path) {
        System.out.println("Abriendo archivo PDF: " + path);
        // Lógica para abrir un archivo PDF
    }

    @Override
    protected void extractData() {
        System.out.println("Extrayendo datos del archivo PDF...");
        // Lógica para extraer datos de un archivo PDF
    }

    @Override
    protected void closeFile() {
        System.out.println("Cerrando archivo PDF.");
        // Lógica para cerrar un archivo PDF
    }
    
}
