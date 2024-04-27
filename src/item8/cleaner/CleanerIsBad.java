package item8.cleaner;

import item8.cleaner.BigObject.ResourceCleaner;
import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsBad {

    // phantom reference랑 유사하다.
    public static void main(String[] args) throws InterruptedException {
        Cleaner cleaner = Cleaner.create();

        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp);
        cleaner.register(bigObject, new ResourceCleaner(resourceToCleanUp));

        // gc가 일어나면서 cleaner가 동작한다.
        bigObject = null;
        System.gc();
        Thread.sleep(3000L);
    }

    // 그러나 권장하는 방법은 Autocloseable을 구현해야 한다.
}
