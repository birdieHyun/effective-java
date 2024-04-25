package item6;

public class Strings {

    public static void main(String[] args) {
        String hello = "hello";
        String hello2 = new String("hello");
        String hello3 = "hello";

        System.out.println(hello == hello2);
        System.out.println(hello == hello3);

        /**
         * 내부적으로 일종의 HashMap 에 한번 만들어진 문자열을 담아두고, 동일한 문자열을 참조하려고 하면, 상수 풀에서 꺼내옴
         * new String, String builder로 시간 비교하는것도 보여주면 좋을 듯
         */

        // effective java repository clone 해서 보기
    }
}
