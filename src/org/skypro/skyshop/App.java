package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("",70));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Яйца", -120));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Молоко"));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Молоко",200,150));
            safelyAddToSearchEngine (searchEngine, safelyCreateProduct("Банан",90));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Первая статья", "Текст"));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Первая статья", "Это моя Первая статья"));
            safelyAddToSearchEngine (searchEngine, safelyCreateArticle("Вторая статья", "Текст"));


        ArrayList<Searchable> searchOne = searchEngine.search("Первая статья Текст");
        ArrayList<Searchable> searchTwo = searchEngine.search("Молоко");

        try {
            Searchable searchTestOne = searchEngine.getMostSuitable("Первая статья");
            System.out.println(searchTestOne);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            Searchable searchTestTwo = searchEngine.getMostSuitable("Инкогнито");
            System.out.println(searchTestTwo);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка " + e.getMessage());
        }

        for (Searchable searchable : searchOne) {
            searchable.getStringRepresentation();
        }

        for (Searchable searchable : searchTwo) {
            searchable.getStringRepresentation();
        }
    }

    private static void safelyAddToSearchEngine(SearchEngine searchEngine, Searchable searchable) {
        if (searchable != null) {
            searchEngine.addObjectToSearchList(searchable);
        }
    }

    private static Searchable safelyCreateProduct(String name, int price, int discount) {
        try {
            return new DiscountProduct(name, price, discount);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Searchable safelyCreateProduct(String name, int price) {
        try {
            return new SimpleProduct(name, price);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Searchable safelyCreateProduct(String name) {
        try {
            return new FixPriceProduct(name);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
    private static Searchable safelyCreateArticle(String title, String body) {
        try {
            return new Article(title, body);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        return null;
    }
}
