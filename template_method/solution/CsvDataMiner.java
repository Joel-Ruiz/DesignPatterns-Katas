public class CsvDataMiner extends DataMiner {

    @Override
    protected void openFile(String path) {
        System.out.println("Abriendo archivo CSV: " + path);
        // Lógica para abrir un archivo CSV
    }

    @Override
    protected void extractData() {
        System.out.println("Extrayendo datos del archivo CSV...");
        // Lógica para extraer datos de un archivo CSV
    }

    @Override
    protected void closeFile() {
        System.out.println("Cerrando archivo CSV.");
        // Lógica para cerrar un archivo CSV
    }
    
}
