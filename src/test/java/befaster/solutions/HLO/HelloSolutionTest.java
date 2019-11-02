package befaster.solutions.HLO;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HelloSolutionTest {

    private HelloSolution helloSolution = new HelloSolution();

    @Test
    public void sayHelloToFriend() {
        String message = helloSolution.hello("joe");
        assertThat(message, is(equalTo("Hello, joe!")));
    }

}
