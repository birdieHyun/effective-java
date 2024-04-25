package item7;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
//        this.cache = new HashMap<>();
        // weakhashmap을 사용하면 cache key가 참조되지 않을 경우 메모리에서 해제된다.
        this.cache = new WeakHashMap<>();
    }

    public Post getPostById(Integer id) {

        CacheKey cacheKey = new CacheKey(id);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }else{
            Post post = new Post();
            cache.put(cacheKey, post);
            return post;
        }
    }

    public Post getPostById2(CacheKey cacheKey) {

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }else{
            Post post = new Post();
            cache.put(cacheKey, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
