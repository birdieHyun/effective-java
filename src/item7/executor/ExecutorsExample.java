package item7.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
        // 이렇게 하게 되면 thread를 매번 생성하기 떄문에 너무 많은 비용이 들어간다. -> ExecutorService를 사용
//        for (int i = 0; i < 100; i++) {
//            Thread thread = new Thread(new Task());
//            thread.start();
//        }
//
//        System.out.println(Thread.currentThread() + " hello");

        // 이렇게 되면 10개의 스레드만 생성해서 스레드를 재사용한다.
        // 그러나 스레드는 CPU의 갯수보다 많이 생성할 수 없음
        int numberOfCpu = Runtime.getRuntime().availableProcessors();

        // blocking queue 사용 , concurrent 하게 접근할 수 있음
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCpu);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }

        executorService.shutdown();

        Executors.newCachedThreadPool(); // 이렇게만 설정하면 그냥 스레드를 생성해서 사용하는거랑 차이가 없음
        // 작업을 위한 공간이 딱 하나임 , queue 가 아님 , 줄 수 있는 스레드가 없으면 무한정 스레드가 생성될 수 있음

        Executors.newSingleThreadExecutor(); // 스레드가 하나만 생성됨 -> 비효율적일 수 있음

        Executors.newScheduledThreadPool(10); // 어떤 작업을 딜레이시키거나, 주기적으로 실행시킬 수 있음

        // callable 사용
        Future<String> submit = executorService.submit(new Task2()); // 여기서는 non blocking

        System.out.println(Thread.currentThread() + " hello");
        System.out.println(submit.get()); // get() 을 호출하면 blocking 됨
    }

    static class Task implements Runnable {


        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " world");
        }
    }

    // runnable 은 작업의 결과를 받을 수 없지만, callable은 작업의 결과를 받을 수 있음
    static class Task2 implements Callable<String> {

        @Override
        public String call() throws Exception {

            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }
}
// executors 에 대해서 공부 후 completable future 에 대해서 공부하기