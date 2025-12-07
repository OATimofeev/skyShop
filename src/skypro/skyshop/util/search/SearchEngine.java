package skypro.skyshop.util.search;

import skypro.skyshop.exception.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String searchString) {
        Map<String, Searchable> founded = new TreeMap<>();

        if (searchString == null || searchString.isEmpty()) {
            return founded;
        }
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(searchString)) {
                founded.put(searchable.searchTerm(), searchable);
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
