package item10.equals.impl;

import java.util.ArrayList;
import java.util.List;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public boolean equals(Object o) {
//        // 객체의 동일성 확인 -> 반사성
//        if (this == o) {
//            return true;
//        }
//
//        // 타입 비교
//        if (!(o instanceof Point)) {
//            return false;
//        }
//
//        // 형변환 후
//        Point p = (Point) o;
//        // 핵심적인 필드들만 비교 -> 부동소수점 영향 받는 애들은 Double.compare()로 비교해야함, reference type은 equals로 비교
//        // primitive type만 ==으로 비교 , null도 허용한다면 Object.equals()가 null을 허용해줌
//        return p.x == x && p.y == y;
//    }

    public boolean equals(Point p) {
        if (this == p) {
            return true;
        }

        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 1);
        List<Point> points = new ArrayList<>();
        points.add(p);

        System.out.println(points.contains(p));
        System.out.println(points.contains(new Point(1, 0)));
    }
}
