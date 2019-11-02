package befaster.solutions.CHL;

import java.util.Collections;
import java.util.Map;

public class CheckliteSolution {

    private Map<Character, Integer> priceTable;

    public CheckliteSolution() {
        this(Collections.emptyMap());
    }

    public CheckliteSolution(Map<Character, Integer> priceTable) {
        this.priceTable = priceTable;
    }

    public Integer checklite(String skus) {
        if (skus == null || skus.trim().isEmpty()) {
            return -1;
        }

        char[] items = skus.toCharArray();
        return priceTable.get(items[0]);
    }
}


