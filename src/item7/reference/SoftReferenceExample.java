package item7.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strongReference = new Object();
        SoftReference<Object> softReference = new SoftReference<>(strongReference);
        // 더이상 strong 하게 reference 하는게 없고, soft reference level로 레퍼런스 하고 있으면 이 오브젝트는 gc의 대상이 된다.
        // -> 메모리가 필요한 상황에서만!
        // GC를 한다고 무조건 없어지는 것이 아님!

        // TODO : 이차원 배열 생성해서 메모리 공간 부족하게 만들고 한번 해보기

        strongReference = null;

        System.gc();
        Thread.sleep(3000L);

        // 거의 안없어짐 -> 메모리가 충분해서
        System.out.println(softReference.get());
        System.out.println(strongReference);
    }
}
