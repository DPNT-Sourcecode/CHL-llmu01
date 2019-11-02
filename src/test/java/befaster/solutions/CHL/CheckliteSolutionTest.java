package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckliteSolutionTest {

    @Mock
    private Map<Character, Integer> priceTable;

    private CheckliteSolution solution;

    @Before
    public void setup() {
        solution = new CheckliteSolution(priceTable);
        when(priceTable.getOrDefault('A', 0)).thenReturn(50);
        when(priceTable.getOrDefault('B', 0)).thenReturn(30);
        when(priceTable.getOrDefault('C', 0)).thenReturn(20);
        when(priceTable.getOrDefault('X', 0)).thenReturn(0);
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
        assertThat(solution.checklite("  "), is(equalTo(-1)));
    }

    @Test
    public void calculateCostOfSingleSku() {
        assertThat(solution.checklite("A"), is(equalTo(50)));
    }

    @Test
    public void calculateUsesValueFromPriceTable() {
        assertThat(solution.checklite("A"), is(equalTo(50)));
        verify(priceTable).get('A');
    }

    @Test
    public void calculateTotalForMultipleSkus() {
        assertThat(solution.checklite("ABC"), is(equalTo(100)));
    }

    @Test
    public void handleLowercaseItems() {
        assertThat(solution.checklite("a"), is(equalTo(50)));
    }

    @Test
    public void ignoreUnrecognisedItems() {
        assertThat(solution.checklite("axB"), is(equalTo(80)));
    }
}
