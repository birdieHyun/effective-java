package item7.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReference2 {

    public static void main(String[] args) throws InterruptedException {
        BigObject strongReference = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        // phantom reference는 queue를 사용해야 한다.
        BigObjectReference<BigObject> phantomReference = new BigObjectReference<>(strongReference, rq);
        strongReference = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(phantomReference.isEnqueued());

        Reference<? extends BigObject> reference = rq.poll();
        BigObjectReference bigObjectReference = (BigObjectReference) reference;
        bigObjectReference.cleanUp();
        reference.clear();

        System.out.println(phantomReference.isEnqueued());
    }
}
