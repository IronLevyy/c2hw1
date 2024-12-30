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
        try {
            safelyAddToSearchEngine(searchEngine,new SimpleProduct("",70));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine,new SimpleProduct("Яйца", -120));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new FixPriceProduct("Молоко"));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new DiscountProduct("Молоко",200,150));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new SimpleProduct("Банан",90));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new Article("Первая статья", "Текст"));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new Article("Первая статья", "Это моя Первая статья"));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        try {
            safelyAddToSearchEngine (searchEngine, new Article("Вторая статья", "Текст"));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }

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
            searchEngine.addObjectToSearchList(searchable);
    }
}
