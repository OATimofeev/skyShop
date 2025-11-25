package skypro.skyshop;

import skypro.skyshop.basket.ProductBasket;
import skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        final String delimiter = "***************************************";

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Задача 1: Добавление продукта в корзину");
        basket1.addProduct(new Product("Банан", 50));
        basket1.addProduct(new Product("Яблоко", 54));
        basket1.addProduct(new Product("Арбуз", 350));
        basket1.addProduct(new Product("Лук", 10));
        basket1.addProduct(new Product("Молоко", 100));

        basket2.addProduct(new Product("Молоток", 270));
        basket2.addProduct(new Product("Картофель", 30));
        basket2.addProduct(new Product("Ряженка", 80));
        System.out.println(delimiter);

        System.out.println("Задача 2: Добавление продукта в заполненную корзину, в которой нет свободного места");
        basket1.addProduct(new Product("Тыква", 300));
        System.out.println(delimiter);

        System.out.println("Задача 3: Печать содержимого корзины с несколькими товарами");
        System.out.println("Корзина 1:");
        basket1.printContent();
        System.out.println();
        System.out.println("Корзина 2:");
        basket2.printContent();
        System.out.println(delimiter);

        System.out.println("Задача 4: Получение стоимости корзины с несколькими товарами");
        System.out.println("Корзина 1, стоимость: " + basket1.getTotalCost());
        System.out.println("Корзина 2, стоимость: " + basket2.getTotalCost());
        System.out.println(delimiter);

        System.out.println("Задача 5: Поиск товара, который есть в корзине");
        System.out.println("Товар есть в корзине 1: " + basket1.isContainProduct("Лук"));
        System.out.println(delimiter);

        System.out.println("Задача 6: Поиск товара, которого нет в корзине");
        System.out.println("Товар есть в корзине 2: " + basket2.isContainProduct("Лук"));
        System.out.println(delimiter);

        System.out.println("Задача 7: Очистка корзины");
        basket2.clean();
        System.out.println("Корзина 2 очищена");
        System.out.println(delimiter);

        System.out.println("Задача 8: Печать содержимого пустой корзины");
        System.out.println("Корзина 2:");
        basket2.printContent();
        System.out.println(delimiter);

        System.out.println("Задача 9: Получение стоимости пустой корзины");
        System.out.println("Корзина 2, стоимость: " + basket2.getTotalCost());
        System.out.println(delimiter);

        System.out.println("Задача 10: Поиск товара по имени в пустой корзине");
        System.out.println("Товар есть в корзине 2: " + basket2.isContainProduct("Лук"));
        System.out.println(delimiter);
    }
}
