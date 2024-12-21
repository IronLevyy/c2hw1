package org.skypro.skyshop.search;

public interface Searcheble {
    String searchTerm();
    String getSearchName();
    String getSearchType();
    default void getStringRepresentation(){
        System.out.println("Название: " + getSearchName() + "\nТип: " + getSearchType());
    }

    default void addObjectToSearchList(Searcheble obj) {
        SearchEngine.addSearcheble(obj);
    }
}
