package befaster.solutions.HLO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloSolutionTest {

    private HelloSolution helloSolution = new HelloSolution();

    @Test
    public void sayHelloToFriend() {
        String message = helloSolution.hello("joe");
        Assertions.assertThat(message).isEqualTo("Hello, joe!");
    }

}