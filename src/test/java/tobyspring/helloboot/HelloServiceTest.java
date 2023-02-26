package tobyspring.helloboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        // given
        SimpleHelloService service = new SimpleHelloService();

        // when
        String ret = service.sayHello("Test");

        // then
        assertThat(ret).isEqualTo("hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        assertThat(ret).isEqualTo("*Test*");
    }
}