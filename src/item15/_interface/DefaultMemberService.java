package item15._interface;

// 이런식으로 구현체는 package-private으로 선언함으로써 내부 구현은 밖에서 모르도록 해야한다.
class DefaultMemberService implements MemberService {

    private String member;

    // 외부의 클래스를 참조하지 않음 (DefaultMemberService 참조 X)
    private static class PrivateStaticClass {

        void doPrint() {
//            System.out.println(member); // member를 참조할 수 없음
        }
    }

    // 외부의 클래스를 참조함 (DefaultMemberService 참조)
    private class PrivateClass {

        void doPrint() {
            System.out.println(member);
        }
    }
}
