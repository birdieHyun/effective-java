package item8.cleaner;

import java.util.List;

public class BigObject {

    // 거대한 이미지 바이트를 사용하고 있어서 정리를 해줘야 한다고 가정
    private List<Object> resource;

    public BigObject(List<Object> resource) {
        this.resource = resource;
    }

    // finalize() 에서 하던 일을 이 클래스가 한다고 보면 된다.
    // inner 클래스로 만들땐 static 으로 만들어야 한다.
    // 그리고 clean을 해주는 작업을 하는데, BigObject의 reference가 절대 있으면 안된다. 정리하려는 오브젝트를 참조하면 안된다.
    // 가비지 컬렉션 BigObject가 없었는데, resource cleaner 에서 BigObject를 참조하기 때문에 객체가 부활할 수도 있음 -> cleaner 작업 중 살아날 수 있음
    public static class ResourceCleaner implements Runnable{
        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up");
        }
    }
}
