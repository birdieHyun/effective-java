package item10.equals.consistency;

import item10.equals.symmetry.Color;
import item10.equals.symmetry.Point;

public class ColorPointComposition {

    private final Point point;
    private final Color color;

    public ColorPointComposition(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
     * @return Point
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointComposition)) {
            return false;
        }
        ColorPointComposition cp = (ColorPointComposition) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
