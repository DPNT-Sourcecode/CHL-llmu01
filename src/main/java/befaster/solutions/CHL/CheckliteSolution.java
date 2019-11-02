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
        if (skus == null) return -1;
        if (skus.trim().isEmpty()) return 0;

        char[] items = skus.toCharArray();

        int total = 0;
        for (Character item: items) {
            total = total + priceTable.get(Character.toUpperCase(item));
        }

        return total;
    }
}


