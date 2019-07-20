package utils.streams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HighestPopulationProblemTest {
    HighestPopulationProblem highestPopulationProblem = new HighestPopulationProblem();

    @Test
    void testFindHighestPopulationProblem() {
        var input = new HashMap<Integer, Integer>();
        input.put(1995, 2010);
        input.put(1975, 2005);
        input.put(1980, 2001);
        input.put(1999, 2010);
        input.put(2000, 2010);
        var expected = Optional.of(2000);
        var actual = highestPopulationProblem.findHighestPopulation(input);
        assertEquals(expected, actual);
    }
}