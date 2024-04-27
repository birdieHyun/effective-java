package item8.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

    private void hi() {

    }

    class InnerClass { // outer class 안에서만 만들 수 있거나, outer class를 거쳐서 만들어야 함

        public void hello() {
            OuterClass.this.hi();
            // cleaner 에서는 static으로 만들어야, 내부 클래스에서 바깥 클래스를 참조하지 않는다.
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass);

        outerClass.printField();
    }

    private void printField() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type:" + field.getType());
            System.out.println("field name:" + field.getName());
        }
    }
}
