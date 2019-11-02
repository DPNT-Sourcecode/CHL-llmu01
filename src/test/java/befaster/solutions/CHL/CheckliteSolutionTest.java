package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckliteSolutionTest {

    private CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void handleEmptySkus() {
        assertThat(solution.checklite(""), is(equalTo(-1)));
    }

    @Test
    public void handleNullSkus() {
        assertThat(solution.checklite(null), is(equalTo(-1)));
    }

    @Test
    public void skuStringIsTrimmed() {
        assertThat(solution.checklite("  "), is(equalTo(-1)));
    }

}