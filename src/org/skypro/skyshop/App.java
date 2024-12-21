package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searcheble;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        SimpleProduct milk = new SimpleProduct("Молоко", 70);
        SimpleProduct eggs = new SimpleProduct("Яйца", 120);
        FixPriceProduct bread = new FixPriceProduct("Молоко");
        DiscountProduct butter = new DiscountProduct("Молоко", 200, 50);
        SimpleProduct banana = new SimpleProduct("Бананы", 90);
        Article firstArticle = new Article("Первая статья", "Текст");
        Article secondArticle = new Article("Вторая статья", "Текст");

        ArrayList<Searcheble> searchOne = SearchEngine.search("Первая статья Текст");
        ArrayList<Searcheble> searchTwo = SearchEngine.search("Молоко");

        for (Searcheble searcheble : searchOne) {
            searcheble.getStringRepresentation();
       }

        for (Searcheble searcheble : searchTwo) {
            searcheble.getStringRepresentation();
       }
    }
}
