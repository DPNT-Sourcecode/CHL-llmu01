package befaster.solutions.CHL;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckliteSolutionTest {

    private Map<Character, Integer> priceTable = new HashMap<>();

    private CheckliteSolution solution = new CheckliteSolution(priceTable);

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

    @Test
    public void calculateCostOfSingleSku() {
        assertThat(solution.checklite("A"), is(equalTo(50)));
    }

    @Test
    public void calculateUsesValueFromPriceTable() {
        priceTable.put('A', 50);


    }
}