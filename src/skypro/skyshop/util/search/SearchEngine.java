package skypro.skyshop.util.search;

import skypro.skyshop.exception.BestResultNotFoundException;
import skypro.skyshop.util.compre.SearchableComparator;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchString) {
        return Optional.ofNullable(searchString)
                .filter(str-> !str.isBlank())
                .map(str ->
                        searchables
                                .stream()
                                .filter(x -> x != null && x.searchTerm().contains(searchString))
                                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())))
                )
                .orElseGet(() -> new TreeSet<>(new SearchableComparator()));

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
