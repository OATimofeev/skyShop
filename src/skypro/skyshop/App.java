package skypro.skyshop;

import skypro.skyshop.article.Article;
import skypro.skyshop.basket.ProductBasket;
import skypro.skyshop.product.DiscountedProduct;
import skypro.skyshop.product.FixPriceProduct;
import skypro.skyshop.product.Product;
import skypro.skyshop.product.SimpleProduct;
import skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

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

        System.out.println("Задача 2: Добавление продукта в заполненную корзину, в которой нет свободного места");
        basket1.addProduct(new SimpleProduct("Тыква", 300));
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

        System.out.println("ООП: полиморфизм, интерфейсы");
        System.out.println(delimiter);

        System.out.println("Демонстрация");
        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(new SimpleProduct("Банан", 50));
        searchEngine.add(new FixPriceProduct("Яблоко"));
        searchEngine.add(new DiscountedProduct("Арбуз", 350, 10));
        searchEngine.add(new SimpleProduct("Лук", 10));
        searchEngine.add(new DiscountedProduct("Молоко", 100, 5));
        searchEngine.add(new DiscountedProduct("Молоток", 270, 25));
        searchEngine.add(new FixPriceProduct("Картофель"));
        searchEngine.add(new SimpleProduct("Ряженка", 80));

        searchEngine.add(new Article("Выращивание вшей на бровях", "Тут есть текст????"));
        searchEngine.add(new Article("Промывка носа пескоструем на лошадях", "Не буду комментировать"));

        System.out.println("Поиск фиксированного товара: " + Arrays.toString(searchEngine.search("Картофель")));
        System.out.println("Поиск обычного товара: " + Arrays.toString(searchEngine.search("Банан")));
        System.out.println("Поиск разных товаров: " + Arrays.toString(searchEngine.search("Моло")));
        System.out.println("Поиск разных товаров и статьи: " + Arrays.toString(searchEngine.search("ло")));
        System.out.println("Поиск статьи по тексту: " + Arrays.toString(searchEngine.search("Не буду комментировать")));
        System.out.println("Поиск несуществующего значения: " + Arrays.toString(searchEngine.search("ТАКОГО ТЕКСТА НЕТ")));
        System.out.println("Поиск пустой строки: " + Arrays.toString(searchEngine.search("")));
        System.out.println("Поиск null-строки: " + Arrays.toString(searchEngine.search(null)));
        System.out.println(delimiter);
    }
}
