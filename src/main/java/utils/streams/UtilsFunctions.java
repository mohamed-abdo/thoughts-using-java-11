package utils.streams;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public interface UtilsFunctions {
    default char getFirstNonRepeatedChar(@NonNull final String input) {
        Objects.requireNonNull(input);
        return (char) input.chars()
                .filter(c -> input.chars().filter(i -> i == c).count() == 1)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("no non repeated character"));
    }

    default boolean isStringsRotated(@NonNull final String first, @NonNull final String second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        if (first.length() != second.length())
            return false;
        if (first.equalsIgnoreCase(second))
            return true;//assume rotation factor is zero;

        var l_first = first
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        final var l_second = second
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        var isRotated = IntStream.range(0, first.length()).filter(i -> {
            Collections.rotate(l_first, 1);
            return (l_first.equals(l_second));
        }).findAny().orElse(-1);

       /* 
        // old style
        for (var i = 0; i < l_first.size(); i++) {
            Collections.rotate(l_first, 1);
            if (l_first.equals(l_second))
                return true;
        }*/

        return isRotated != -1;
    }

    BigDecimal sampleOf_map_flatMap_reduce(final String... args);
}
