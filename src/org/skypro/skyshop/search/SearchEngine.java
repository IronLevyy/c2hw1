package org.skypro.skyshop.search;

import java.util.ArrayList;

public class SearchEngine{
    private ArrayList<Searchable> searchables = new ArrayList<>();

    public void addSearcheble(Searchable obj) {
        searchables.add(obj);
    }

    public ArrayList<Searchable> search(String searchParam) {
        ArrayList<Searchable> searched = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().equals(searchParam)) {
                searched.add(searchable);
            }
            if (searched.size() == 5) {
                break;
            }
        }
        return searched;
    }
    public void addObjectToSearchList(Searchable obj) {
        searchables.add(obj);
    }

}
