public class KnuthMorrisPratt {

    //O(pattern.length)
    public static int[] findPrefixArray(String pattern)
    {
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
            else{
                if(j == 0) {
                    lsp[i] = 0;
                    i++;
                }
                else
                    j = lsp[j-1];
            }
        }
        return lsp;
    }

    //O(line.length)
    public static void KMP(String pattern, String line)
    {
        String[] t = pattern.split("");
        String[] a = line.split("");

        int[] lsp = findPrefixArray(pattern);

        int i = 0;
        int j = 0;

        while(i < a.length)
        {
            if(a[i].equals(t[j])) {
                i++; j++;
                if(j == t.length) {
                    System.out.println("Образец найден");
                    //System.exit(0);
                }
            }
            else{
                if(j > 0)
                    j = lsp[j-1];
                else
                    i++;
            }
        }
        if(i == a.length) {
            System.out.println("Образец не найден");
            System.exit(0);
        }
    }

    //O(n + m)
    public static void main(String[] args)
    {
        KMP("аабааб", "абабабабаабаабааббабабаб");
    }
}