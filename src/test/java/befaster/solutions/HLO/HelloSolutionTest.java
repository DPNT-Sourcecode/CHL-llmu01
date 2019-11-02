package befaster.solutions.HLO;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HelloSolutionTest {

    private HelloSolution helloSolution;

    @Test
    public void sayHello() {
        String message = helloSolution.hello("joe");
        assertThat(message, is(equalTo("Hello")));
    }

}