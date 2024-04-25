package item1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;
        Collections.sort(list, desc);

        System.out.println(list);
    }
}
