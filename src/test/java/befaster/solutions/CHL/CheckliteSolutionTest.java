package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckliteSolutionTest {

    private CheckliteSolution solution;

    @Before
    public void setup() {
        solution = new CheckliteSolution();
    }

    @Test
    public void handleEmptySkus() {
        assertThat(solution.checklite(""), is(equalTo(0)));
    }

    @Test
    public void handleNullSkus() {
        assertThat(solution.checklite(null), is(equalTo(-1)));
    }

    @Test
    public void skuStringIsTrimmed() {
        assertThat(solution.checklite("  "), is(equalTo(0)));
    }

    @Test
    public void calculateCostOfSingleSku() {
        assertThat(solution.checklite("A"), is(equalTo(50)));
    }

    @Test
    public void calculateUsesValueFromPriceTable() {
        assertThat(solution.checklite("A"), is(equalTo(50)));
    }

    @Test
    public void calculateTotalForMultipleSkus() {
        assertThat(solution.checklite("ABC"), is(equalTo(100)));
    }

    @Test
    public void handleLowercaseItems() {
        assertThat(solution.checklite("a"), is(equalTo(-1)));
    }

    @Test
    public void ignoreUnrecognisedItems() {
        assertThat(solution.checklite("axB"), is(equalTo(-1)));
    }

    @Test
    // Can be done using a parameterised test but I have trouble setting up gradle  with junit 5
    public void checkoutWithMultipleQuantitiesOfSameItem() {
        assertThat(solution.checklite("ABA"), is(equalTo(130)));
        assertThat(solution.checklite("AAA"), is(equalTo(130)));
        assertThat(solution.checklite("AAABB"), is(equalTo(175)));
        assertThat(solution.checklite("ABCDABCD"), is(equalTo(215)));
    }
}