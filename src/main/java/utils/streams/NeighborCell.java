package utils.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class NeighborCell {
    List<Integer> cellCompete(int[] states, int days) {
        AtomicReference<List<Integer>> atomic = new AtomicReference<>(Arrays.stream(states)
                .boxed().collect(Collectors.toList()));

        IntStream.range(0, days).forEachOrdered(i -> {
            atomic.set(cellCompete(atomic.get()));
        });
        return atomic.get();
    }

    private static List<Integer> cellCompete(List<Integer> states) {
        //get new list of copy from input array
        List<Integer> statesCopy = new ArrayList<>(states);
        //add left edge
        statesCopy.add(0, 0);
        //add right edge
        statesCopy.add(0);
        // loop over input
        return IntStream.range(1, statesCopy.size() - 1)
                .boxed()
                .map(i -> getActiveCellState(statesCopy.get(i - 1), statesCopy.get(i + 1)))
                .collect(Collectors.toList());

    }

    private static int getActiveCellState(int a, int b) {
        return a == b ? 0 : 1;
    }
}
