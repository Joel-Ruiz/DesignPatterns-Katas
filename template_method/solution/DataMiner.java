public abstract class DataMiner {

    // El Template Method es FINAL para que nadie cambie el algoritmo
    public final void mine(String path) {
        openFile(path);
        extractData();
        analyzeData(); // Paso común implementado aquí
        closeFile();
    }

    // Pasos que las subclases DEBEN implementar
    protected abstract void openFile(String path);
    protected abstract void extractData();
    protected abstract void closeFile();

    // Paso común (Hooks o implementación concreta compartida)
    protected void analyzeData() {
        System.out.println("Analizando datos con lógica de negocio estándar...");
    }
}