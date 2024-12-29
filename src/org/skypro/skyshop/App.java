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
        try {
            SimpleProduct milk = milk = new SimpleProduct(" ", 70);
            searchEngine.addObjectToSearchList(milk);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            SimpleProduct eggs = new SimpleProduct("Яйца", -120);
            searchEngine.addObjectToSearchList(eggs);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            FixPriceProduct bread = new FixPriceProduct("Молоко");
            searchEngine.addObjectToSearchList(bread);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            DiscountProduct butter = new DiscountProduct("Молоко", 200, 150);
            searchEngine.addObjectToSearchList(butter);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            SimpleProduct banana = new SimpleProduct("Бананы", 90);
            searchEngine.addObjectToSearchList(banana);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            Article article = new Article("Первая статья", "Текст");
            searchEngine.addObjectToSearchList(article);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            Article article = new Article("Первая статья", "Это моя Первая статья.");
            searchEngine.addObjectToSearchList(article);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            Article article = new Article("Вторая статья", "Текст");
            searchEngine.addObjectToSearchList(article);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        ArrayList<Searchable> searchOne = searchEngine.search("Первая статья Текст");
        ArrayList<Searchable> searchTwo = searchEngine.search("Молоко");

        try {
            Searchable searchTestOne = searchEngine.getMostSuitable("Первая статья");
            System.out.println(searchTestOne);
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }
        try {
            Searchable searchTestTwo = searchEngine.getMostSuitable("Инкогнито");
            System.out.println(searchTestTwo);
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        for (Searchable searchable : searchOne) {
            searchable.getStringRepresentation();
        }

        for (Searchable searchable : searchTwo) {
            searchable.getStringRepresentation();
        }
    }
}
