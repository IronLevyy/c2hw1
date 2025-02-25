package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.function.Predicate;

public class SearchComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        return o1.getSearchName().toLowerCase().compareTo(o2.getSearchName().toLowerCase());
    }
}
