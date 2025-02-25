package org.skypro.skyshop.search;

import java.util.Comparator;

public class LengthTermComparator implements Comparator <Searchable>{
    public int compare(Searchable s1, Searchable s2) {
        int compareResult = Integer.compare(s1.getSearchName().length(), s2.getSearchName().length());
        if (compareResult == 0) {
            return s1.compareTo(s2);
        } else {
            return compareResult;
        }
    }
}
