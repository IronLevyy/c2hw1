package org.skypro.skyshop.search;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine{
    private Set<Searchable> searchables = new HashSet<Searchable>();

    public void addSearcheble(Searchable obj) {
        searchables.add(obj);
    }

    public Set<Searchable>search(String searchParam) {
        TreeSet<Searchable> searched = searchables.stream()
                .filter(searchable -> searchable.getSearchName().toLowerCase().contains(searchParam.toLowerCase()))
                .collect(Collectors.toCollection(()->(new TreeSet<Searchable>(new SearchComparator()))));
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
