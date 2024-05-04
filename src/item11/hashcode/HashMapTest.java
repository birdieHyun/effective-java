package item11.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber number1 = new PhoneNumber(111, 222, 333);
        PhoneNumber number2 = new PhoneNumber(111, 222, 333);

        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());

        map.put(number1, "whiteship");
        map.put(number2, "donghyun");

        System.out.println(map.get(number1));
        System.out.println(map.get(number2));
        System.out.println(map.get(new PhoneNumber(111, 222, 333)));
    }
}

