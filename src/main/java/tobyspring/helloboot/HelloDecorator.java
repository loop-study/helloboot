package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// 부가적인 기능만 추가해도 데코레이터다.
@Service
@Primary    // 겹치는 Bean이 존재하면 이걸 사용하게 한다.
public class HelloDecorator implements HelloService {
    private HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

}
