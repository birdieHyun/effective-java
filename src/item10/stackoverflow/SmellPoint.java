package item10.stackoverflow;

import item10.equals.symmetry.Color;
import item10.equals.symmetry.ColorPoint;
import item10.equals.symmetry.Point;

public class SmellPoint extends Point {

    private String smell;

    public SmellPoint(int x, int y, String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        // 만약 ColorPoint를 equals로 받게 된다면?
        // colorPoint equals smellPoint -> 계속 재귀적으로 서로를 equals를 부르게 됨
        if (!(o instanceof SmellPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((SmellPoint) o).smell.equals(smell);
    }

    public static void main(String[] args) {
        SmellPoint sp = new SmellPoint(1, 2, "good");
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(sp.equals(cp));
    }
}
