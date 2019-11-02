package befaster.solutions.CHL;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckliteSolutionTest {

    private CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void handleEmptySkus() {
        assertThat(solution.checklite("")).isEqualTo(-1);
    }

    @Test
    public void handleNullSkus() {
        assertThat(solution.checklite(null)).isEqualTo(-1);
    }

    @Test
    public void skuStringIsTrimmed() {
        assertThat(solution.checklite("   ")).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource({"", ""})
    public void calculateCostOfSingleSku() {
        assertThat(solution.checklite("A")).isEqualTo(50);
    }
}