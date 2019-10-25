package utils.streams;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NeighborCellTest {
    @org.junit.jupiter.api.Test
    void cellCompeteTest() {
        var results = new NeighborCell().cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1);
        var expected = Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0);
        Assertions.assertTrue(results.equals(expected), "incorrect cells");
    }
}