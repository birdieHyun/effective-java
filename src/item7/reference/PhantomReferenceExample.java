package item7.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 유령 레퍼런스
 *
 * soft 나 weak과 다르게 레퍼런스를 지워주는것이 아닌, phantom reference가 strong reference 대신 남아있음
 */
public class PhantomReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        BigObject strongReference = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        // phantom reference는 queue를 사용해야 한다.
        PhantomReference<BigObject> phantomReference = new PhantomReference<>(strongReference, rq);
        strongReference = null;

        System.gc();
        Thread.sleep(3000L);

        // 예제에서 좋은 deprecated가 있음 -> 이거 대신 뭐쓸지 찾아보기
        // 죽었지만 사라지지 않고 queue 에 들어감
        // 팬텀은 바로 사라지지 않고 래퍼런스 큐에 넣어주는 것임
        // strong = null 을 해주지 않으면 queue에 들어가지 않기 때문에 false가 나옴
        // 나중에 reference에서 꺼내서 정리할 수 있음
        // phantom reference의 용도는 두가지가 있음
        // 자원 정리할 때 쓸 수 있음, (finalize 쓰지 않고, 이 방법을 사용해서 정리하는게 나음, 그러나 이 방법을 쓰지 않음
        // finalize = 최악, 그다음이 phantom reference, 그다음이 try with resource를 사용하는 것임
        System.out.println(phantomReference.isEnqueued());
//        System.out.println(phantomReference.refersTo(strongReference));

        Reference<? extends BigObject> reference = rq.poll();

        // clear까지 해야 phantom reference가 사라짐
        reference.clear();
        System.out.println(phantomReference.isEnqueued());
    }

    // phantom reference를 사용하는 이유는, 언제 무거운 객체가 해제가 되는지 알 수 있기 때문에 사용한다.
    // 사라짐과 동시에 phantom reference 가 queue에 들어가기 때문에 알 수 있는것 (거의 안쓰긴 함)

    // 자원을 반납하려는 용도로 쓰려면 다음 방법이 있음
}
