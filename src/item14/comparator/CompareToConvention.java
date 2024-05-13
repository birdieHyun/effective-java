package item14.comparator;

import java.math.BigDecimal;

public class CompareToConvention {

    public static void main(String[] args) {
        // compare to 에서 -1, 0, 1을 기대하면 안되고, 양수인지 음수인지 등을 판단해야 한다!
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(53534552);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // 반사성
        System.out.println(n1.compareTo(n1));

        // 대칭성
        System.out.println(n1.compareTo(n2));
        System.out.println(n2.compareTo(n1));

        // 추이성
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        // 일관성 (equals랑 조금 다른 느낌) - 두 수가 같다면 하위와 같아야 한다.
        System.out.println(n4.compareTo(n2));
        System.out.println(n2.compareTo(n1));
        System.out.println(n4.compareTo(n1));

        // compareTo가 0이라면 equals는 true여야 한다. (아닐수도 있음) - 이건 깨진 경우임
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");

        System.out.println(oneZero.compareTo(oneZeroZero)); // Tree, Treemap 에는 둘 중 하나만 들어가지만
        System.out.println(oneZero.equals(oneZeroZero)); // false , 일반 컬렉션에는 둘 다 들어감
    }


    private static int sgn(int value) {
        return Integer.compare(value, 0);
    }
}
