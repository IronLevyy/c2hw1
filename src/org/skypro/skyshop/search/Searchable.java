package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();
    String getSearchName();
    String getSearchType();
    default void getStringRepresentation(){
        System.out.println("Название: " + getSearchName() + "\nТип: " + getSearchType());
    }
    default int compareTo(Searchable other){
        return getSearchName().compareTo(other.getSearchName());
    }
}
