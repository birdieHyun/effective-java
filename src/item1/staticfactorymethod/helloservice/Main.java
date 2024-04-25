package item1.staticfactorymethod.helloservice;

public class Main {

    public static void main(String[] args) {
        // 어떤 구현체인지 숨길 수 있다.
        HelloService helloService = HelloService.of("ko");

    }
}
