import java.util.Arrays;

public class Main {

    final static String sample = "A".repeat(50000) + "B";
    static final String line = "A".repeat(100000) + "B";

    public static void main(String[] args) {

        KMP(sample, line); //39845000
        //KMP("АБАБВГА", "АБАБАБВГА");

        NS(sample, line); //4131612400
        //NS("ЛИИЛЛИИАЛИИЛ", "ЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛЛИИЛЛИИАЛИИЛ");
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
    }

}
