import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public List<ProductSales> analyzeSales(List<Sale> sales) {
        return sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .sorted(Comparator.comparingDouble((ProductSales ps) -> ps.totalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}