package item7.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strongReference = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(strongReference);
        strongReference = null;

        System.gc();
        Thread.sleep(3000L);

        // weak reference 는 soft reference와 다르게 없어짐 -> 메모리를 신경쓰지 않고!
        System.out.println(weakReference.get());
    }

}
