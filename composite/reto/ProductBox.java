package composite.reto;

import java.util.ArrayList;
import java.util.List;

public class ProductBox {
    private final String name;
    private final List<Object> children = new ArrayList<>();

    public ProductBox(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Object component) {
        children.add(component);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        
        for (Object component : children) {
            // PROBLEMA: El código debe verificar el tipo para saber qué método llamar
            if (component instanceof Product) {
                totalPrice += ((Product) component).getPrice();
            } else if (component instanceof ProductBox) {
                // Llamada recursiva, pero dependemos de la interfaz del ProductBox
                totalPrice += ((ProductBox) component).calculateTotalPrice();
            } else {
                // Manejar otros tipos no esperados
                System.err.println("Advertencia: Componente desconocido en la caja.");
            }
        }
        return totalPrice;
    }
}