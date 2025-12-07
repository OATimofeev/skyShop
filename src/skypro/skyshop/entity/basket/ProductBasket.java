package skypro.skyshop.entity.basket;

import skypro.skyshop.entity.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (basket.containsKey(product.getName())) {
            basket.get(product.getName()).add(product);
        } else {
            basket.put(product.getName(), new ArrayList<>(List.of(product)));
        }
    }

    public int getTotalCost() {
        return getTotalCost(false);
    }

    public void printContent() {
        getTotalCost(true);
    }

    private int getTotalCost(boolean withPrint) {
        int total = 0;
        int specialTotal = 0;
        for (Map.Entry entry : basket.entrySet()) {
            for (Product product : (ArrayList<Product>) entry.getValue()) {
                if (product != null) {
                    total += product.getPrice();
                    if (product.isSpecial()) {
                        specialTotal++;
                    }
                    if (withPrint) {
                        System.out.println(product);
                    }
                }
            }
        }
        if (withPrint) {
            System.out.println(total == 0 ? "В корзине пусто!" : "Итого: %d".formatted(total));
            System.out.printf("Специальных товаров: %d%n", specialTotal);
        }
        return total;
    }

    public boolean isContainProduct(String productName) {
        return basket.containsKey(productName);
    }

    public List<Product> deleteProduct(String productName) {
        List<Product> deletedProductList = new ArrayList<>();
        if (basket.containsKey(productName)) {
            deletedProductList = basket.get(productName);
            basket.remove(productName);
        }
        return deletedProductList;
    }

    public void clear() {
        basket.clear();
    }
}
