import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String,Integer> dictionary = new HashMap<String,Integer>();
    static String[] input()
    {
        String S = "Hello, world!";
        String[] arrS = S.split("");
        return arrS;
    }
    static void dictionaryCompletion(String[] arrS)
    {
        for(int i = 0; i < arrS.length; i++)
        {
            if(!dictionary.containsKey(arrS[i]))
            {
                dictionary.put(arrS[i], 0);
            }
            dictionary.put(arrS[i], dictionary.get(arrS[i])+1);
        }
    }
    static int findMax(String[] arrDistincted)
    {
        int max = -1;
        for(int i = 0; i < arrDistincted.length; i++)
        {
            if (dictionary.get(arrDistincted[i]) > max)
                max = dictionary.get(arrDistincted[i]);
        }
        return max;
    }
    static void makeHistogram(String[] arrDistincted )
    {
        int max = findMax(arrDistincted);
        for(int i = max; i > 0; i--)
        {
            for(int j = 0; j < arrDistincted.length; j++)
            {
                if(dictionary.get(arrDistincted[j]) < i)
                    System.out.print(" " + " ");
                else
                    System.out.print("#" + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arrDistincted.length; i++)
        {
            System.out.print(arrDistincted[i] + " ");
        }
    }
    public static void main(String[] args)
    {
        dictionaryCompletion(input());
        String[] arrDistincted = dictionary.keySet().toArray(new String[0]);
        makeHistogram(arrDistincted);
    }
}