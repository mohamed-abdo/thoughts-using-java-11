package utils.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTransformerTest {
    @Test
    void zeroTransformTest() {
        int[][] m = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        int[][] results = new MatrixTransformer().zeroTransform(m);

        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};

        Assertions.assertTrue(Arrays.deepEquals(results, expected), "incorrect transformation");
    }
}