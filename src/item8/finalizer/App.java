package item8.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        int i = 0;
        while (true) {
            i++;
            new FinalizeIsBad(); // 생성만 하면 gc가 돼야 함 (참조가 없기 때문)
            // 가비지 컬렉션이 되면 finalize() 가 어떤 queue 에 들어가게 된다.

            if ((i % 1_000_000) == 0) {
                Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
                Field queueStaticField = finalizerClass.getDeclaredField("queue");
                queueStaticField.setAccessible(true);
                ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);

                Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
                queueLengthField.setAccessible(true);
                long queueLength = (long) queueLengthField.get(referenceQueue);
                System.out.format("There are %d references in the queue%n", queueLength);
            }
        }
    }
}
