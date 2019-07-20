package utils.streams;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UtilsFunctionsImpl implements UtilsFunctions {
    public BigDecimal sampleOf_map_flatMap_reduce(final String... args) {
        return Arrays.stream(args)
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(BigDecimal::new)
                .reduce(BigDecimal::add)
                .orElseThrow(NumberFormatException::new);
    }

    public int sumOfFactors() {
        int n = Integer.MAX_VALUE - 1;

        int[] facts = IntStream.range(1, (int) Math.sqrt(n) + 1)
                .filter(i -> n % i == 0).toArray();

        int[] remaining = Arrays.stream(facts)
                .map(i -> n / i).toArray();

        int sum = Stream.of(facts, remaining)
                .flatMapToInt(Arrays::stream)
                .reduce(0, Integer::sum);
        return sum;
    }


}
