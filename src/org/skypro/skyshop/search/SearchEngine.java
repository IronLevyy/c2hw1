package org.skypro.skyshop.search;

import java.util.ArrayList;

public class SearchEngine{
    private static ArrayList<Searcheble> searchebles = new ArrayList<>();

    public static void addSearcheble(Searcheble obj) {
        searchebles.add(obj);
    }

    public static ArrayList<Searcheble> search(String searchParam) {
        ArrayList<Searcheble> searched = new ArrayList<>();
        for (Searcheble searcheble : searchebles) {
            if (searcheble.searchTerm().equals(searchParam)) {
                searched.add(searcheble);
            }
            if (searched.size() == 5) {
                break;
            }
        }
        return searched;
    }

}
