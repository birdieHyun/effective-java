package item1.staticfactorymethod.helloservice;

public interface HelloService {

    void hello();

    // java 8 이후부터는 인터페이스에서 static 메서드를 제공할 수 있어서 이와같이 팩터리 클래스를 만들지 않고 생성할 수 있다.
    static HelloService of(String lang) {

        if (lang.equals("ko")) {
            return new KoreanHelloService();
        }
        return new EnglishHelloService();
    }
}
