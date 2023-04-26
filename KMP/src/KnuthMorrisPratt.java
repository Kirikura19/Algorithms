import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnuthMorrisPratt {

    //O(pattern.length)
    public static int[] findPrefixArray(String pattern) {
        String[] a = pattern.split("");
        int[] lsp = new int[pattern.length()];

        lsp[0] = 0;
        int j = 0;
        int i = 1;

        while(i < lsp.length) {
            if(a[j].equals(a[i])) {
                lsp[i] = j+1;
                i++; j++;
            }
            else {
                if(j == 0) {
                    lsp[i] = 0;
                    i++;
                }
                else {
                    j = lsp[j-1];
                }
            }
        }
        return lsp;
    }

    //O(line.length)
    public static int[] KMP(String pattern, String line) {
        String[] t = pattern.split("");
        String[] a = line.split("");

        int[] lsp = findPrefixArray(pattern);

        int i = 0;
        int j = 0;
        List<Integer> indices = new ArrayList<>();

        while(i < a.length) {
            if(a[i].equals(t[j])) {
                i++; j++;
                if(j == t.length) {
                    indices.add(i - j);
                    j = lsp[j-1];
                }
            }
            else {
                if(j > 0) {
                    j = lsp[j-1];
                }
                else {
                    i++;
                }
            }
        }

        int[] result = new int[indices.size()];
        for(int k = 0; k < result.length; k++) {
            result[k] = indices.get(k);
        }
        return result;
    }

    //O(n + m)
    public static void main(String[] args) {
        int[] indices = KMP("аабааб", "абабабабаабаабааббабабаб");
        if(indices.length == 0) {
            System.out.println("Образец не найден");
        }
        else {
            System.out.println("Образец найден в следующих позициях: " + Arrays.toString(indices));
        }
    }
}
