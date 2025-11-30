import java.util.ArrayList;
import java.util.List;

public class ProductBox implements InventoryComponent {
    private String name;
    private List<InventoryComponent> children = new ArrayList<>();

    public ProductBox(String name) {
        this.name = name;
    }

    public void add(InventoryComponent component) {
        children.add(component);
    }

    public void remove(InventoryComponent component) {
        children.remove(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (InventoryComponent child : children) {
            total += child.getPrice();
        }
        return total;
    }

    @Override
    public String getName() {
        return name;
    }
}