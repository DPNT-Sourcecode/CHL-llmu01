package befaster.solutions.CHL;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckliteSolutionTest {

    private CheckliteSolution solution = new CheckliteSolution();

    @Test
    void handleEmptySkus() {
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
    @MethodSource("stringIntProvider")
    public void calculateCostOfSingleSku(String sku, int total) {
        assertThat(solution.checklite(sku)).isEqualTo(total);
    }

    static Stream<Arguments> stringIntProvider() {
        return Stream.of(
                arguments("A", 50),
                arguments("B", 30)
        );
    }
}

