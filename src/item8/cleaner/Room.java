package item8.cleaner;

import java.lang.ref.Cleaner;

public class Room  implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    // 방의 상태. cleanable과 공유한다.
    private final State state;

    // cleanalbe 객체. 수거 대상이 되면 방을 청소한다.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state); // gc가 되면 cleaner queue 에 들어가게 된다. 그리고 cleaner에 등록된 state 작업이 실행되는 것 (state.run())
    }

    @Override
    public void close() {
        cleanable.clean();
    }

    // 청소가 필요한 자원 -> 절대 Room 을 참조하면 안된다.
    private static class State implements Runnable {
        int numJunkPiles; // 방 안의 쓰레기 수

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // close 메서드나 cleaner가 호출된다.
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }
}
