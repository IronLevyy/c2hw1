package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine{
    private Set<Searchable> searchables = new HashSet<Searchable>();

    public void addSearcheble(Searchable obj) {
        searchables.add(obj);
    }

    public Set<Searchable>search(String searchParam) {
        Set<Searchable> searched = new TreeSet<>(new LengthTermComparator());
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().equals(searchParam)) {
                searched.add(searchable);
            }
        }
        return searched;
    }
    public void addObjectToSearchList(Searchable obj) {
        searchables.add(obj);
    }

    public Searchable getMostSuitable(String search) throws BestResultNotFound {
        Searchable searched = null;
        int maxCount = 0;
        for (Searchable obj : searchables) {
            int count = 0;
            int index = 0;
            int subIndex = obj.searchTerm().indexOf(search, index);
            while (subIndex != -1) {
                count++;
                index = index + search.length();
                subIndex = obj.searchTerm().indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                searched = obj;
            }
        }
        if (searched == null) {
            throw new BestResultNotFound("Подходящего элемента не найдено");
        }
        return searched;
    }

}
