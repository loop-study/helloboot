package tobyspring.helloboot;

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
}