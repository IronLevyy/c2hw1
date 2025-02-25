package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        int sum = basket.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
        return sum;
    }

    public void printContentBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        basket.values().stream().flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("Итого: " + getPriceBasket());
        System.out.println("Специальных товаров: " + getSpetialProductCount());
    }

    private long getSpetialProductCount() {
        long SpetialProductCount = basket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        return SpetialProductCount;
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
        Iterator<String> iterator = basket.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            if(basket.get(key).contains(productName)) {
                deletedProducts.addAll(basket.get(key));
                iterator.remove();
            }
        }
        return deletedProducts;
    }
}
