import java.util.Arrays;

public class Main {

    final static String sample = "A".repeat(500000) + "B";
    static final String line = "A".repeat(1000000) + "B";

    public static void main(String[] args) {
       // KMP(sample, line);
        KMP("АБАБВГА", "АБАБВАБАБАБВГА");

        // NS(sample, line);
      //  NS("ЛИИЛЛИИАЛИИЛ", "ЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛ");
    }

    public static void NS(String sample, String line)
    {

        Long startTime = System.nanoTime();

        NaiveSearch ns = new NaiveSearch(sample, line);
        System.out.println(ns.search());

        Long endTime = System.nanoTime();

        System.out.println("Время исполнения " + (endTime - startTime));
    }

    public static void KMP(String sample, String line)
    {
        Long startTime = System.nanoTime();

        KnuthMorrisPratt kmp = new KnuthMorrisPratt(sample, line);
        kmp.findPrefixArray();
        System.out.println(kmp.KMP().toString());

        Long endTime = System.nanoTime();

        System.out.println("Время исполнения " + (endTime - startTime));
        System.out.println(Arrays.toString(kmp.lsp));
    }

}
