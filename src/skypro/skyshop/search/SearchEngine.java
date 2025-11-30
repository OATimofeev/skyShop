package skypro.skyshop.search;

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

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }
}
