package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        SimpleProduct milk = new SimpleProduct("Молоко", 70);
        searchEngine.addObjectToSearchList(milk);
        SimpleProduct eggs = new SimpleProduct("Яйца", 120);
        searchEngine.addObjectToSearchList(eggs);
        FixPriceProduct bread = new FixPriceProduct("Молоко");
        searchEngine.addObjectToSearchList(bread);
        DiscountProduct butter = new DiscountProduct("Молоко", 200, 50);
        searchEngine.addObjectToSearchList(butter);
        SimpleProduct banana = new SimpleProduct("Бананы", 90);
        searchEngine.addObjectToSearchList(banana);
        Article firstArticle = new Article("Первая статья", "Текст");
        searchEngine.addObjectToSearchList(firstArticle);
        Article secondArticle = new Article("Вторая статья", "Текст");
        searchEngine.addObjectToSearchList(secondArticle);

        ArrayList<Searchable> searchOne = searchEngine.search("Первая статья Текст");
        ArrayList<Searchable> searchTwo = searchEngine.search("Молоко");

        for (Searchable searchable : searchOne) {
            searchable.getStringRepresentation();
       }

        for (Searchable searchable : searchTwo) {
            searchable.getStringRepresentation();
       }
    }
}
