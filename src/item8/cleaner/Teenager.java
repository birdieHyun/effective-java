package item8.cleaner;

// 이렇게 하면 자원 반납이 안되고 끝날수도 있음 -> try with resource를 사용하는 것이 좋음
public class Teenager {

    public static void main(String[] args) {
        new Room(99);

        System.out.println("peace out");

        // 다음 줄의 주석을 해제한 후 동작을 다시 확인해보자.
        // 단, 가비지 컬렉션을 강제로 호출하는 이런 방식에 의존해서는 안된다.
        System.gc();
    }
}
