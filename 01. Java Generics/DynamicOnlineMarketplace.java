import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() { return "Book"; }
}

class ClothingCategory implements Category {
    public String getCategoryName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getCategoryName() { return "Gadget"; }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }
    public void setPrice(double price) { this.price = price; }
    public String toString() { return name + " (" + category.getCategoryName() + ") - $" + price; }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100.0);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();
        Product<BookCategory> book1 = new Product<>("Java Programming", 49.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 19.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());
        catalog.add(book1);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("Catalog Before Discount:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        MarketplaceUtils.applyDiscount(book1, 10);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(phone, 5);

        System.out.println("\nCatalog After Discount:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }
}