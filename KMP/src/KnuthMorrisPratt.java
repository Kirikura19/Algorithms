import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnuthMorrisPratt {

    private String line;
    private String sample;
    public int[] lsp;
    private String[] splitSample;
    private String[] splitLine;

    public KnuthMorrisPratt(String sample, String line) {
        this.line = line;
        this.sample = sample;
        this.lsp = new int[sample.length()];
        this.splitSample = sample.split("");
        this.splitLine = line.split("");
    }

    //O(pattern.length)
    public void findPrefixArray() {
        String[] splitLine = sample.split("");
        lsp[0] = 0;
        int j = 0, i = 1;
        while(i < lsp.length) {
            if(splitLine[j].equals(splitLine[i])) {
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
    }

    //O(line.length)
    public List<Integer> KMP() {
        int i = 0;
        int j = 0;
        List<Integer> indices = new ArrayList<>();
        while (i < splitLine.length) {
            if (splitLine[i].equals(splitSample[j])) {
                i++;
                j++;
                if (j == splitSample.length) {
                    indices.add(i - j);
                    j = lsp[j - 1];
                }
            } else {
                if (j > 0) {
                    j = lsp[j - 1];
                } else {
                    i++;
                }
            }
        }
        return indices;
    }
}
