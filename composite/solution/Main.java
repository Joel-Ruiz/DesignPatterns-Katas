public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Creando Inventario con Composite Pattern ---");

        // 1. Creamos productos individuales (Hojas)
        // Nota: Podemos declararlos como 'InventoryComponent' o 'Product', ambos funcionan.
        InventoryComponent camisa = new Product("Camisa de Algodón", 25.00);
        InventoryComponent pantalon = new Product("Pantalón de Lona", 50.00);
        InventoryComponent calcetines = new Product("Calcetines", 5.00);
        InventoryComponent corbata = new Product("Corbata de Seda", 15.00);

        // 2. Creamos una caja pequeña (Compuesto)
        // Nota: Aquí necesitamos que sea 'ProductBox' para acceder al método 'add'
        ProductBox cajaAccesorios = new ProductBox("Caja de Accesorios");
        cajaAccesorios.add(calcetines);
        cajaAccesorios.add(corbata);

        // 3. Creamos una caja grande que contiene productos y la otra caja (Compuesto Recursivo)
        ProductBox granPedido = new ProductBox("Paquete de Envío #1");
        granPedido.add(camisa);
        granPedido.add(pantalon);
        granPedido.add(cajaAccesorios);

        // Calculamos el precio de un ítem simple
        System.out.println("\nPrecio de la Camisa (Individual): $" + camisa.getPrice());

        // Calculamos el precio de una caja compleja
        System.out.println("Precio del Gran Pedido (Total): $" + granPedido.getPrice());
        
        // Verificación manual: (25 + 50) + (5 + 15) = 95
    }
}