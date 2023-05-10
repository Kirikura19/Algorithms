import java.util.ArrayList;
import java.util.List;

public class NaiveSearch {

    private String string;
    private String pattern;

    public NaiveSearch(String pattern, String string) {
        this.string = string;
        this.pattern = pattern;
    }

    public List search() {
        int n = string.length();
        int m = pattern.length();

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (string.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                indices.add(i);
            }
        }
        return indices;
    }
}