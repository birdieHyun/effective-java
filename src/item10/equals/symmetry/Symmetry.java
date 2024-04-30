package item10.equals.symmetry;

public class Symmetry {

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        ColorPoint colorPoint = new ColorPoint(1, 1, Color.BLUE);

        System.out.println(point.equals(colorPoint));
        System.out.println(colorPoint.equals(point));

        //--------------------------추이성 문제 --------------------------------------
        ColorPoint p1 = new ColorPoint(1, 1, Color.RED);
        Point p2 = new Point(1, 1);
        ColorPoint p3 = new ColorPoint(1, 1, Color.BLUE);

        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
