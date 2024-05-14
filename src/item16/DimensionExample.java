package item16;

import java.awt.Button;
import java.awt.Dimension;

public class DimensionExample {

    public static void main(String[] args) {
        Button button = new Button();
        button.setBounds(0, 0, 20, 10);

        Dimension size = button.getSize();
        System.out.println(size.width);
        System.out.println(size.height);
    }

    private static void doSomething(Dimension dimension) {
        Dimension dimension1 = new Dimension();
        dimension1.width = dimension.width;
        dimension1.height = dimension.height;
    }
}
