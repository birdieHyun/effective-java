package item10.equals.symmetry;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    // 이렇게 하면 리스코프 치환원칙이 깨짐
//    public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
