import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract String getDetails();
    public String toString() { return getName() + ": " + getDetails(); }
}

class Electronics extends WarehouseItem {
    private String brand;
    public Electronics(String name, String brand) { super(name); this.brand = brand; }
    public String getDetails() { return "Electronics [Brand: " + brand + "]"; }
}

class Groceries extends WarehouseItem {
    private String expiryDate;
    public Groceries(String name, String expiryDate) { super(name); this.expiryDate = expiryDate; }
    public String getDetails() { return "Groceries [Expiry: " + expiryDate + "]"; }
}

class Furniture extends WarehouseItem {
    private String material;
    public Furniture(String name, String material) { super(name); this.material = material; }
    public String getDetails() { return "Furniture [Material: " + material + "]"; }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public T getItem(int index) { return items.get(index); }
    public List<T> getAllItems() { return items; }
}

class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Apple"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "2025-05-01"));
        groceriesStorage.addItem(new Groceries("Bread", "2025-04-30"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getAllItems());
    }
}