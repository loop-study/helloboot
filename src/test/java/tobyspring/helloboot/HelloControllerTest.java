package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {

    @Test
    void helloController() {
        // given
        HelloController controller = new HelloController(name -> name);

        // when
        String ret = controller.hello("Test");

        // then
        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        // given
        HelloController controller = new HelloController(name -> name);

        // when, then
        assertThatThrownBy(() -> controller.hello(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> controller.hello(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}