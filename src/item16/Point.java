package item16;

public class Point {

    public double x;
    public double y;

//    public static void main(String[] args) {
//        Point point = new Point();
//
//        // 이런식으로 직접 접근하면 값이 들어올 때 제한을 둔다거나, 네이밍을 할 수 없게 된다.
//        point.x = 10;
//        point.y = 20;
//    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (y < 0) {
            throw new IllegalArgumentException("y는 0보다 작을 수 없습니다.");
        }
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("x는 0보다 작을 수 없습니다.");
        }
        this.x = x;
    }
}
