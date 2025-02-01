package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> basket = new ArrayList<>();

    public void addProduct(Product target) {
        basket.add(target);
    }

    public int getPriceBasket() {
        int totalPrice = 0;
        for (Product product : basket) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void printContentBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        int specialProductCounter = 0;
        for (Product product : basket) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialProductCounter++;
            }
        }
        System.out.println("Итого: " + getPriceBasket());
        System.out.println("Специальных товаров: " + specialProductCounter);
    }

    public boolean checkContentNameInBasket(String name) {
        for (Product product : basket) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> deleteProductFromBasket(String productName) {
        List<Product> deletedProducts = new ArrayList<>();
        List<Product> basketToDelete = new ArrayList<>(basket);
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(productName)) {
                basketToDelete.remove(product);
                deletedProducts.add(product);
            }
        }
        clearBasket();
        basket.addAll(basketToDelete);
        return deletedProducts;
    }
}
