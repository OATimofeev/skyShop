package skypro.skyshop;

import skypro.skyshop.basket.ProductBasket;
import skypro.skyshop.product.DiscountedProduct;
import skypro.skyshop.product.FixPriceProduct;
import skypro.skyshop.product.Product;
import skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) {
        final String delimiter = "***************************************";

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Задача 1: Добавление продукта в корзину");
        basket1.addProduct(new SimpleProduct("Банан", 50));
        basket1.addProduct(new FixPriceProduct("Яблоко"));
        basket1.addProduct(new DiscountedProduct("Арбуз", 350, 10));
        basket1.addProduct(new SimpleProduct("Лук", 10));
        basket1.addProduct(new DiscountedProduct("Молоко", 100, 5));

        basket2.addProduct(new DiscountedProduct("Молоток", 270, 25));
        basket2.addProduct(new FixPriceProduct("Картофель"));
        basket2.addProduct(new SimpleProduct("Ряженка", 80));
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
        basket2.clear();
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

        System.out.println("Задача 11: Метод удаления продукта по имени из корзины");
        System.out.println("Удаляем продукт лук");
        List<Product> deleted = basket1.deleteProduct("лук");
        System.out.println("Список удаленных продуктов: " + deleted);
        System.out.println();
        System.out.println("Список продуктов в корзине");
        basket1.printContent();
        System.out.println();
        System.out.println("Удаляем несуществующий продукт: фвыаывап");
        deleted = basket1.deleteProduct("фвыаывап");
        System.out.println();
        System.out.println("Список удаленных продуктов: " + deleted);
        System.out.println();
        System.out.println("Список продуктов в корзине");
        basket1.printContent();
        System.out.println(delimiter);
    }
}
