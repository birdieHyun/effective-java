package item1.staticfactorymethod.helloservice;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloService = loader.findFirst();
        helloService.ifPresent(h -> helloService.get().hello());
    }
}
