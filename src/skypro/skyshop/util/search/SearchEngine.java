package skypro.skyshop.util.search;

import skypro.skyshop.exception.BestResultNotFoundException;

public class SearchEngine {

    private Searchable[] searchables;

    public SearchEngine(int num) {
        searchables = new Searchable[num];
    }

    public Searchable[] search(String searchString) {
        Searchable[] founded = new Searchable[5];
        if (searchString == null || searchString.isEmpty()) {
            return founded;
        }
        int counter = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(searchString)) {
                founded[counter++] = searchable;
            }
            if (counter == 5) {
                break;
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
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }
}
