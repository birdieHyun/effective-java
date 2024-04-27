package item8.finalizer;

public class AccountMain {

    public static void main(String[] args) throws InterruptedException {
//        Account 푸틴 = new Account("푸틴"); // 이렇게만 하면 예외 발생 종료됨

        try {
            new BrokenAccount("푸틴"); // 부모의 생성자를 사용하기 때문에 예외는 동일하게 발생하게 된다.
        }catch (Exception e) {
            System.out.println("이러면??");
        }
        System.gc(); // finalizer가 실행되고 어플리케이션이 종료됨
        Thread.sleep(3000L);
    }

}
