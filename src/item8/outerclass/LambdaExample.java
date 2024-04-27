package item8.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {

    private static int value = 10;

    // 이렇게 하면 가비지 컬렉터가 동작하지 않는다.
    private Runnable instanceLambda = () -> System.out.println(value);

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();
        Field[] fields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field type:" + field.getType());
            System.out.println("field name:" + field.getName());
        }

    }
}
