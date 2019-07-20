package utils.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public interface StreamsUtils {
    default Map<String, String> partitionString(final String dataSheet) {
        final int chunk = 2;
        AtomicInteger counter = new AtomicInteger();
        Map<String, String> pairs = Arrays.stream(dataSheet.split(","))
                .map(String::trim)
                .collect(Collectors.groupingBy(i -> counter.getAndIncrement() / chunk))
                .values()
                .stream()
                .collect(toMap(k -> k.get(0), v -> v.get(1)));
        return pairs;
    }
}
