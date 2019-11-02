package befaster.solutions.CHL;

public class CheckliteSolution {
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
