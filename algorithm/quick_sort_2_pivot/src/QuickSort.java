import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }
        if (list.get(0).compareTo(list.get(1)) > 0) Collections.swap(list, 0, 1);

        T a = list.get(0), b = list.get(1);

        List<T> l1 = new ArrayList<>(),
                l2 = new ArrayList<>(), l3 = new ArrayList<>();

        for (T comparable : list.subList(2, list.size())) {
            if (comparable.compareTo(a) < 0) {
                l1.add(comparable);
                continue;
            }
            if (comparable.compareTo(b) < 0) {
                l2.add(comparable);
                continue;
            }
            l3.add(comparable);
        }

        sort(l1);sort(l2);sort(l3);
        l1.add(a);
        l2.add(b);
        List<T> list2 = Stream.of(l1, l2, l3).flatMap(Collection::stream).toList();

        Collections.copy(list, list2);
    }
}
