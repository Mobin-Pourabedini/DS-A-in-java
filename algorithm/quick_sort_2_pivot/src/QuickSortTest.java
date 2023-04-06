import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void f() {
        List<Comparable<Integer>> l1 = new ArrayList<>(List.of(5, 6, 3, 4, 1, 7, 9));
        QuickSort.sort(l1);
        assert (l1.equals(List.of(1, 3, 4, 5, 6, 7, 9)));
    }
}