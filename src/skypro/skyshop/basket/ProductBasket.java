package skypro.skyshop.basket;

import skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт, корзина заполнена!");
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

    public void clean() {
        basket = new Product[5];
    }
}
