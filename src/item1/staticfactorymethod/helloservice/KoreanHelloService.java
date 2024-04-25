package item1.staticfactorymethod.helloservice;

import item1.staticfactorymethod.helloservice.HelloService;

public class KoreanHelloService implements HelloService {


    @Override
    public void hello() {
        System.out.println("안녕하세요");
    }
}
