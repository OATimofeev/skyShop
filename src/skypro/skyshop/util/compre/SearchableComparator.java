package skypro.skyshop.util.compre;

import skypro.skyshop.util.search.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        String s1 = o1.searchTerm();
        String s2 = o2.searchTerm();
        int lengthCompareResult = Integer.compare(s2.length(), s1.length());
        if (lengthCompareResult != 0) {
            return lengthCompareResult;
        }

        return s1.compareTo(s2);
    }
}
