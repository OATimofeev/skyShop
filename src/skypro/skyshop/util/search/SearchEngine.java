package skypro.skyshop.util.search;

import skypro.skyshop.exception.BestResultNotFoundException;
import skypro.skyshop.util.compre.SearchableComparator;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchString) {
        Set<Searchable> founded = new TreeSet<>(new SearchableComparator());

        if (searchString == null || searchString.isEmpty()) {
            return founded;
        }
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(searchString)) {
                founded.add(searchable);
            }
        }
        return founded;
    }

    public Searchable searchBest(String searchString) throws BestResultNotFoundException {
        Searchable current = null;
        int maxCurrencies = 0;
        int currencies;

        for (Searchable searchable : searchables) {
            String operatedString = searchable.searchTerm().toLowerCase().replace(searchString.toLowerCase(), "");
            currencies = (searchable.searchTerm().length() - operatedString.length()) / searchString.length();
            if (currencies > maxCurrencies) {
                current = searchable;
                maxCurrencies = currencies;
            }
        }
        if (current == null) {
            throw new BestResultNotFoundException("Не найден ни один подходящий элемент");
        }
        return current;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
}
