package skypro.skyshop;

import skypro.skyshop.entity.article.Article;
import skypro.skyshop.entity.basket.ProductBasket;
import skypro.skyshop.entity.product.DiscountedProduct;
import skypro.skyshop.entity.product.FixPriceProduct;
import skypro.skyshop.entity.product.Product;
import skypro.skyshop.entity.product.SimpleProduct;
import skypro.skyshop.exception.BestResultNotFoundException;
import skypro.skyshop.util.search.SearchEngine;

import java.util.Arrays;

import java.util.List;

public class App {
    public static void main(String[] args) {
        final String delimiter = "***************************************";
        final String demo = "Демонстрация";

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

        System.out.println("ООП: полиморфизм, интерфейсы");
        System.out.println(delimiter);

        System.out.println(demo);
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

        System.out.println("Поиск фиксированного товара: " + searchEngine.search("Картофель"));
        System.out.println("Поиск обычного товара: " + searchEngine.search("Банан"));
        System.out.println("Поиск разных товаров: " + searchEngine.search("Моло"));
        System.out.println("Поиск разных товаров и статьи: " + searchEngine.search("ло"));
        System.out.println("Поиск статьи по тексту: " + searchEngine.search("Не буду комментировать"));
        System.out.println("Поиск несуществующего значения: " + searchEngine.search("ТАКОГО ТЕКСТА НЕТ"));
        System.out.println("Поиск пустой строки: " + searchEngine.search(""));
        System.out.println("Поиск null-строки: " + searchEngine.search(null));
        System.out.println(delimiter);

        System.out.println("Исключения в Java");
        System.out.println(delimiter);

        System.out.println(demo);
        System.out.println("Конструкторы");
        try {
            System.out.println("Имя из пробелов");
            new FixPriceProduct("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Имя == null");
            new DiscountedProduct(null, 80, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Имя пустое");
            new SimpleProduct("", 80);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Простой продукт, цена == 0");
            new SimpleProduct("Тестик", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Простой продукт, цена < 0");
            new SimpleProduct("Тестик", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Скидочный продукт, цена < 0");
            new SimpleProduct("Тестик", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        try {
            System.out.println("Скидочный продукт, цена > 100");
            new SimpleProduct("Тестик", 101);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Поиск");

        try {
            System.out.print("Существующий объект ");
            searchEngine.searchBest("АН");
            System.out.println("найден");
            System.out.println();
        } catch (BestResultNotFoundException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }

        try {
            System.out.println("Объекта нет");
            searchEngine.searchBest("дядя");
        } catch (BestResultNotFoundException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
        System.out.println(delimiter);

        System.out.println("Java Collections Framework: List");
        System.out.println(delimiter);

        System.out.println(demo);
        System.out.println("Конструкторы");

        System.out.println("Метод удаления продукта по имени из корзины");
        System.out.println("Удаляем продукт лук");
        System.out.println("Список удаленных продуктов: " + basket1.deleteProduct("лук"));
        System.out.println();
        System.out.println("Список продуктов в корзине");
        basket1.printContent();
        System.out.println();
        System.out.println("Удаляем несуществующий продукт: фвыаывап");
        System.out.println("Список удаленных продуктов: " + basket1.deleteProduct("фвыаывап"));
        System.out.println();
        System.out.println("Список продуктов в корзине");
        basket1.printContent();

        System.out.println("Поиск по списку");

        System.out.println("Поиск обычного товара: " + searchEngine.search("Арбуз"));
        System.out.println("Поиск несуществующего товара: " + searchEngine.search("Пусто"));
        System.out.println("Поиск разных товаров и статьи: " + searchEngine.search("ло"));
        System.out.println(delimiter);
    }
}
