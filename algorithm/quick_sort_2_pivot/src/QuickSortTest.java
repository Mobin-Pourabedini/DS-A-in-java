import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void simpleSortIntTest() {
        List<Integer> l = new ArrayList<>(List.of(5, 6, 3, 4, 1, 7, 9));
        QuickSort.sort(l);
        assert (l.equals(l.stream().sorted().toList()));
    }

    @Test
    void simpleSortDoubleTest() {
        List<Double> l = new ArrayList<>(List.of(-1.23, -3.23, 1.3, 2.0, 43.3));
        QuickSort.sort(l);
        assert (l.equals(l.stream().sorted().toList()));
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void bigSortIntTest() {
        Random random = new Random(0);
        Supplier<Integer> integerSupplier = random::nextInt;
        List<Integer> l = new ArrayList<>(Stream.generate(integerSupplier).limit(100000).toList());
        QuickSort.sort(l);
        assert (l.equals(l.stream().sorted().toList()));
    }
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void bigSortDoubleTest() {
        Random random = new Random(0);
        Supplier<Double> integerSupplier = random::nextDouble;
        List<Double> l = new ArrayList<>(Stream.generate(integerSupplier).limit(100000).toList());
        QuickSort.sort(l);
        assert (l.equals(l.stream().sorted().toList()));
    }
}