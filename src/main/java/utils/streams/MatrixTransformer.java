package utils.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixTransformer {
    int[][] zeroTransform(int[][] matrix) {
        int[][] mc = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        int[] a = new int[]{1, 2, 4};

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    rowZeroTransform(mc, r);
                    colZeroTransform(mc, c);
                    break;
                }
            }
        }
        return mc;
    }

    private void rowZeroTransform(int[][] matrix, int rowIdx) {
        IntStream.range(0, matrix[rowIdx].length)
                .forEachOrdered(c -> matrix[rowIdx][c] = 0);
    }

    private void colZeroTransform(int[][] matrix, int colIdx) {
        IntStream.range(0, matrix.length)
                .forEachOrdered(r -> matrix[r][colIdx] = 0);
    }
}
