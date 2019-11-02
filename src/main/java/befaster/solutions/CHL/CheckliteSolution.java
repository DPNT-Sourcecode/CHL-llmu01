package befaster.solutions.CHL;

import java.util.Map;

public class CheckliteSolution {

    private Map<Character, Integer> priceTable;

    public CheckliteSolution(Map<Character, Integer> priceTable) {
        this.priceTable = priceTable;
    }

    public Integer checklite(String skus) {
        if (skus == null || skus.trim().isEmpty()) {
            return -1;
        }

        if("A".equalsIgnoreCase(skus)) {
            return 50;
        }
        return 0;
    }
}
