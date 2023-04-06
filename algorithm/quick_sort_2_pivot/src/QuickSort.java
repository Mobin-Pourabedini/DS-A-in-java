import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    public static <T> void sort(List<Comparable<T>> list) {
        if (list.size() <= 1) {
            return;
        }
        if (cmp(list.get(0), list.get(1)) > 0) Collections.swap(list, 0, 1);

        Comparable<T> a = list.get(0), b = list.get(1);

        List<Comparable<T>> l1 = new ArrayList<>(),
                l2 = new ArrayList<>(), l3 = new ArrayList<>();

        for (Comparable<T> comparable : list.subList(2, list.size())) {
            if (cmp(comparable, a) < 0) {
                l1.add(comparable);
                continue;
            }
            if (cmp(comparable, b) < 0) {
                l2.add(comparable);
                continue;
            }
            l3.add(comparable);
        }

        sort(l1);sort(l2);sort(l3);
        l1.add(a);
        l2.add(b);
        List<Comparable<T>> list2 = Stream.of(l1, l2, l3).flatMap(Collection::stream).toList();

        Collections.copy(list, list2);
    }

    private static <T> int cmp(Comparable<T> comparable1, Comparable<T> comparable2){
        return comparable1.compareTo((T) comparable2);
    }
}
