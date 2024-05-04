package item11.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashCollisionTest {

    public static void main(String[] args) {
        Map<PhoneNumberCollision, String> map = new HashMap<>();
        PhoneNumberCollision number1 = new PhoneNumberCollision(111, 222, 333);
        PhoneNumberCollision number2 = new PhoneNumberCollision(222, 333, 444);

        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());

        map.put(number1, "whiteship");
        map.put(number2, "donghyun");

        System.out.println(map.get(new PhoneNumberCollision(111, 222, 333)));
        System.out.println(map.get(new PhoneNumberCollision(222, 333, 444)));
    }
}
