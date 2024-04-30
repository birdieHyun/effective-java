package item10.equals.transitivity;

import item10.equals.symmetry.Point;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * equals를 재정의하지 않아서 Point의 equals를 사용
 */
public class CounterPoint extends Point {

    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated() {
        return counter.get();
    }
}
