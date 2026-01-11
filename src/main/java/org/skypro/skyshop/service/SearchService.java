package org.skypro.skyshop.service;

import lombok.AllArgsConstructor;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchService {

    private final StorageService storageService;

    public List<SearchResult> search(String searchString) {
        return storageService.getAll().stream()
                .filter(x -> x.getStringRepresentation().contains(searchString))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
