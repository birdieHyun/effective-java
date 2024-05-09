package item13.treeset;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(4);
        numbers.add(6);

        for (Integer number : numbers) {
            System.out.println(number);
        }

        // 만약 Integer가 아닌 내가 만든 객체를 넣으려고 하면 알 수 없는 부분이기 때문에 ClassCastException이 발생한다.
        // -> 해결을 위해 Comparator를 구현해야 함

//        동기화를 원한다면
        Set<Integer> nums = Collections.synchronizedSet(numbers);
    }
}
