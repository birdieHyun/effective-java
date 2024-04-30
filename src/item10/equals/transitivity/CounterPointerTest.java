package item10.equals.transitivity;

import item10.equals.consistency.ColorPointComposition;
import item10.equals.symmetry.Color;
import item10.equals.symmetry.ColorPoint;
import item10.equals.symmetry.Point;
import java.util.Set;

public class CounterPointerTest {

    private static final Set<Point> unitCircle = Set.of(
        new Point(1, 0), new Point(0, 1),
        new Point(-1, 0), new Point(0, -1)
    );

    public static boolean onUnitCircle(Point point) {
        return unitCircle.contains(point);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);

        System.out.println(onUnitCircle(p1)); // true
        System.out.println(onUnitCircle(p2)); // false -> 두 클래스의 getClas()가 다르기 때문에 false가 나옴

        //------------------ consistency -----------
        Point p3 = new Point(1, 0);
        Point p4 = new ColorPoint(1, 0, Color.RED); // 상속한 color point임 -> 여기서 상속이 아닌 compoistion을 사용하면 어떻게 할 수 있을까
//        Point p5 = new item10.equals.consistency.ColorPoint(1, 0, Color.RED); 이렇게 할 수 없음 -> composition을 사용했기 떄문에 Point View를 colorpoint 안에 구현함
        Point p5 = new ColorPointComposition(1, 0, Color.RED).asPoint();
        System.out.println(onUnitCircle(p5));
    }
}
