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
    private static SearchEngine searchEngine = new SearchEngine();
    public static void main(String[] args) {

            createSimpleProduct("",70);
            createSimpleProduct("Яйца", -120);
            createFixPriceProduct("Молоко");
            createDiscountProduct("Молоко",200,150);
            createSimpleProduct("Банан",90);
            createArticle("Первая статья", "Текст");
            createArticle("Первая статья", "Это моя Первая статья");
            createArticle("Вторая статья", "Текст");

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

    private static void createSimpleProduct(String name, int price) {
        try {
            SimpleProduct product = new SimpleProduct(name, price);
            searchEngine.addObjectToSearchList(product);
        } catch (Exception e) {
            System.err.println("Ошибка " + e.getMessage());
        }
    }
    private static void createDiscountProduct(String name, int price, int discount) {
        try {
            DiscountProduct product = new DiscountProduct(name, price, discount);
            searchEngine.addObjectToSearchList(product);
        } catch (Exception e) {
            System.err.println("Ошибка " + e.getMessage());
        }
    }
    private static void createFixPriceProduct(String name) {
        try {
            FixPriceProduct product = new FixPriceProduct(name);
            searchEngine.addObjectToSearchList(product);
        } catch (Exception e) {
            System.err.println("Ошибка " + e.getMessage());
        }
    }
    private static void createArticle(String title, String body) {
        try {
            Article article = new Article(title, body);
            searchEngine.addObjectToSearchList(article);
        } catch (Exception e) {
            System.err.println("Ошибка " + e.getMessage());
        }
    }
}
