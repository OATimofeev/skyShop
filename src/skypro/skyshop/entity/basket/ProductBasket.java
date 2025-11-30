package skypro.skyshop.entity.basket;

import skypro.skyshop.entity.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
        basket.add(product);
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
        for (Product product : basket) {
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
        if (withPrint) {
            System.out.println(total == 0 ? "В корзине пусто!" : "Итого: %d".formatted(total));
            System.out.printf("Специальных товаров: %d%n", specialTotal);
        }
        return total;
    }

    public boolean isContainProduct(String productName) {
        for (Product product : basket) {
            if (product != null && product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> deleteProduct(String productName) {
        List<Product> deletedProductList = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(productName)) {
                deletedProductList.add(product);
                basket.remove(product);
            }
        }
        return deletedProductList;
    }

    public void clear() {
        basket.clear();
    }
}
