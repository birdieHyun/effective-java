package item10.equals.transitivity;

import java.sql.Date;
import java.sql.Timestamp;

public class Transitivity {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(time);

        System.out.println(date.equals(timestamp)); // true
        System.out.println(timestamp.equals(date)); // false
    }
}
