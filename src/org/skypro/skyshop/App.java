package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Хлеб",70));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Яйца", 120));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Молоко"));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Молоко",200,50));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Банан",90));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Первая статья", "Текст"));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Первая статья", "Это моя Первая статья"));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Вторая статья", "Текст"));


        Map<String, Searchable> searchOne = searchEngine.search("Первая статья Текст");
        Map<String, Searchable> searchTwo = searchEngine.search("Молоко");

        try {
            Searchable searchTestOne = searchEngine.getMostSuitable("Первая статья");
            System.out.println(searchTestOne);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка " + e.getMessage());
        }

        for (String key : searchOne.keySet()) {
            searchOne.get(key).getStringRepresentation();
        }

        for (String key : searchTwo.keySet()) {
            searchTwo.get(key).getStringRepresentation();
        }

        ProductBasket basket = new ProductBasket();
        basket.addProduct(safelyCreateProduct("Хлеб",70));
        basket.addProduct(safelyCreateProduct("Яйца", 120));
        basket.addProduct(safelyCreateProduct("Молоко"));
        basket.addProduct(safelyCreateProduct("Молоко",200,50));
        basket.addProduct(safelyCreateProduct("Масло",200,50));
        basket.addProduct(safelyCreateProduct("Банан",90));


        System.out.println(basket.deleteProductFromBasket("Молоко"));
        basket.printContentBasket();
        System.out.println(basket.deleteProductFromBasket("Машина"));
        basket.printContentBasket();
    }



    private static void safelyAddToSearchEngine(SearchEngine searchEngine, Searchable searchable) {
        if (searchable != null) {
            searchEngine.addObjectToSearchList(searchable);
        }
    }

    private static Product safelyCreateProduct(String name, int price, int discount) {
        try {
            return new DiscountProduct(name, price, discount);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Product safelyCreateProduct(String name, int price) {
        try {
            return new SimpleProduct(name, price);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Product safelyCreateProduct(String name) {
        try {
            return new FixPriceProduct(name);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Article safelyCreateArticle(String title, String body) {
        try {
            return new Article(title, body);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }


}
