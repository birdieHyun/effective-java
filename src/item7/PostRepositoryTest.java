package item7;


class PostRepositoryTest {

    public static void main(String[] args) throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        Integer p1 = 1;
        postRepository.getPostById(p1);

        // 비어있지 않음
        System.out.println(postRepository.getCache().size());

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        // size == 0 이어야 하지만 비어있지 않게 됨
        System.out.println(postRepository.getCache().size());

        //-----------------------------
        // 이렇게 하면 weak reference를 쓰더라도 cacheKey가 참조되고 있기 때문에 GC되지 않음
        CacheKey cacheKey = new CacheKey(2); // 그런데 cacheKey를 나중에 null 처리 할 경우! GC됨!!
        postRepository.getPostById2(cacheKey);

        // 그러나 이렇게 할 경우 CacheKey가 참조되는 곳이 없기 때문에 GC됨
//        postRepository.getPostById2(new CacheKey(2));
        System.out.println(postRepository.getCache().size());


        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        System.out.println(postRepository.getCache().size());
    }
}