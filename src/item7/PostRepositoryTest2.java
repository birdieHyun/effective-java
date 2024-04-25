package item7;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PostRepositoryTest2 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        PostRepository repository = new PostRepository();
        CacheKey cacheKey = new CacheKey(1);
        repository.getPostById2(cacheKey);

        Runnable removeOldCache = () -> {
            System.out.println("remove old cache");
            Map<CacheKey, Post> cache = repository.getCache();
            Set<CacheKey> cacheKeys = cache.keySet();

            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));

            key.ifPresent((k) -> {
                System.out.println("removing " + k);
                cache.remove(k);
            });

        };

        System.out.println("The time is : " + new Date());
        executor.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(20000L);
        executor.shutdown();
    }
}
