package composite.challenge;

public class Main {
    public static void main(String[] args) {
        
        // 1. Crear Productos individuales (Hojas)
        Product camisa = new Product("Camisa de Algodón", 25.0);
        Product pantalon = new Product("Pantalón de Lona", 50.0);
        Product calcetines = new Product("Calcetines (Par)", 5.0);

        // 2. Crear una caja base (Compuesto)
        ProductBox cajaRopa = new ProductBox("Caja de Ropa Casual");
        cajaRopa.add(camisa);
        cajaRopa.add(pantalon);
        
        // 3. Crear una sub-caja (Composición recursiva)
        ProductBox cajaAccesorios = new ProductBox("Caja de Accesorios");
        cajaAccesorios.add(calcetines);
        cajaAccesorios.add(new Product("Corbata", 15.0));
        
        // 4. Crear la caja Maestra que contiene otra caja
        ProductBox cajaMaestra = new ProductBox("Gran Kit de Regalo");
        cajaMaestra.add(cajaRopa);           // Añadir otra caja
        cajaMaestra.add(cajaAccesorios);     // Añadir la sub-caja
        cajaMaestra.add(new Product("Tarjeta de Regalo", 10.0)); // Añadir una hoja
        
        // --- Cálculo y demostración del problema ---
        
        // Problema: Si quiero saber el precio de una camisa, llamo a getPrice().
        // Si quiero saber el precio de una caja, llamo a calculateTotalPrice().
        // El cliente (Main) debe saber distinguir entre Product y ProductBox.
        
        System.out.println("--- Reporte de Precios del Inventario ---");
        
        System.out.println("Precio de la Camisa: $" + camisa.getPrice()); 
        
        // El cliente debe recordar el método de la Caja
        System.out.println("Precio de la Caja Maestra: $" + cajaMaestra.calculateTotalPrice()); 
        
        // ¿Qué pasa si queremos aplicar un descuento?
        // Habría que modificar la lógica dentro de ProductBox.calculateTotalPrice, 
        // y también dentro de Product.getPrice() (si existiera un método de descuento).
        
        // Precio total esperado: (25.0 + 50.0) + (5.0 + 15.0) + 10.0 = $105.0
    }
}