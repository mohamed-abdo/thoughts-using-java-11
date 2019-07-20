package utils.streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HighestPopulationProblem {
    public Optional<Integer> findHighestPopulation(HashMap<Integer, Integer> input) {
        //flatten lists
        return input.entrySet().stream().
                flatMap(i -> IntStream.range(i.getKey(), i.getValue()).boxed())
                .collect(Collectors.groupingBy(g -> g)).entrySet()
                .stream().map((a) ->
                        Map.entry(a.getKey(), a.getValue().size())
                ).max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }
}