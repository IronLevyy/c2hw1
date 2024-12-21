package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searcheble;

public abstract class Product implements Searcheble {
    private final String name;

    public Product(String name) {
        this.name = name;
        addObjectToSearchList(this);
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String getSearchName() {
        return name;
    }

    @Override
    public String getSearchType() {
        return "Product";
    }
}
