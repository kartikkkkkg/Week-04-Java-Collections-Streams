import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> productPricesLinkedHashMap = new LinkedHashMap<>();
    private Map<String, Double> productPricesTreeMap = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        productPricesLinkedHashMap.put(product, price);
        productPricesTreeMap.put(product, price);
    }

    public void displayProducts(Map<String, Double> productMap) {
        for (Map.Entry<String, Double> entry : productMap.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }

    public void displaySortedProducts() {
        System.out.println("\nProducts in TreeMap (Sorted by Product):");
        displayProducts(productPricesTreeMap);
    }

    public void displayProductsInOrder() {
        System.out.println("\nProducts in LinkedHashMap (Order of Insertion):");
        displayProducts(productPricesLinkedHashMap);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.0);
        cart.addProduct("Banana", 0.5);
        cart.addProduct("Cherry", 2.0);
        cart.displayProductsInOrder();
        cart.displaySortedProducts();
    }
}