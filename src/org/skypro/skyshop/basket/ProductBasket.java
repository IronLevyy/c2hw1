package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ProductBasket {
    private Map<String, ArrayList<Product>> basket = new HashMap<>();

    public void addProduct(Product target) {
        if(!basket.containsKey(target.getName())) {
            ArrayList<Product> products = new ArrayList<>();
            products.add(target);
            basket.put(target.getName(), products);
        }else {
            basket.get(target.getName()).add(target);
        }
    }

    public int getPriceBasket() {
        int totalPrice = 0;
        for (String key : basket.keySet()) {
            for(Product product : basket.get(key)) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printContentBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        int specialProductCounter = 0;
        for (String key : basket.keySet()) {
            for(Product product : basket.get(key)) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialProductCounter++;
                }
            }
        }
        System.out.println("Итого: " + getPriceBasket());
        System.out.println("Специальных товаров: " + specialProductCounter);
    }

    public boolean checkContentNameInBasket(String name) {
        if(basket.containsKey(name)) {
            return true;
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> deleteProductFromBasket(String productName) {
        List<Product> deletedProducts = new ArrayList<>();
        for (String key : basket.keySet()) {
                if (productName.trim().equals(key)) {
                    basket.remove(key);
                }
        }
        return deletedProducts;
    }
}
