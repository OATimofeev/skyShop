package skypro.skyshop.entity.basket;

import skypro.skyshop.entity.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();

    private int totalCost = 0;
    int specialTotal = 0;


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
        totalCost = 0;
        specialTotal = 0;
        basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(product -> {
                    if (product.isSpecial()) {
                        specialTotal++;
                    }
                    totalCost += product.getPrice();
                    System.out.println(product);
                });
        if (withPrint) {
            System.out.println(totalCost == 0 ? "В корзине пусто!" : "Итого: %d".formatted(totalCost));
            System.out.printf("Специальных товаров: %d%n", specialTotal);
        }
        return totalCost;
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
