package befaster.solutions.CHL;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckliteSolutionTest {

    private CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void handleEmptySkus() {
        assertThat(solution.checklite(""), is(equalTo(-1)));
    }

}