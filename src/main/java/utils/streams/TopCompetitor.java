package utils.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TopCompetitor {
    ArrayList<String> topNCompetitors(int numCompetitors,
                                      int topNCompetitors,
                                      List<String> competitors,
                                      int numReviews,
                                      List<String> reviews) {

        // iterate of competitors, for each get word index
        final String splitter = " ";
        return (ArrayList<String>) competitors.stream().map(competitor ->
                new AbstractMap.SimpleEntry<String, Integer>(competitor,
                        getWordIndex(String.join(splitter, reviews), competitor, splitter)))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey))
                .entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey,
                        v -> v.getValue().stream().mapToInt(AbstractMap.SimpleEntry::getValue).sum()))
                .entrySet()
                .stream()
                .sorted(compareEntry
                        .thenComparing(comparing(Map.Entry::getKey)))
                .limit(topNCompetitors)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Comparator<Map.Entry<String, Integer>> compareEntry =
            comparing(Map.Entry::getValue, Comparator.reverseOrder());

    private int getWordIndex(String phrase, String word, String splitter) {
        return Arrays.stream(phrase.split(splitter))
                .collect(Collectors.groupingBy(String::toLowerCase))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().size()))
                .getOrDefault(word, 0);
    }
}
