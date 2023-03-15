import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static int[] makeRandArr(int length, int range)
    {
        int[] array;
        array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * length) - range);
            // System.out.println(array[i]);
        }
        return array;
    }
    public static double someSorts(String type, int[] array)
    {

        long startTime = System.nanoTime();
        switch(type)
        {
            case("count"):
                countingSort(array);
                break;
            case("quick"):
                Arrays.sort(array);
                break;
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1_000_000_000.0;
        return duration;
    }
    public static int findMin(int[] arr)
    {
        int min = arr[0] + 1;
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i]< min)
            {
                min = arr[i];
            }
        }
        return min;
    }
    public static int findMax(int[] arr)
    {
        int max = arr[0] - 1;
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i]> max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static List<Integer> countingSort(int[] arr)
    {
        List<Integer> answer = new ArrayList<>();
        //O(n)
        int min = findMin(arr);
        int max = findMax(arr);

        int[] countingArr = new int[max-min+1];

        //O(n)
        for(int i = 0; i < arr.length; i++)
            countingArr[arr[i] - min] += 1;

        //O(n + k)
        for(int i = 0; i < countingArr.length; i++)
            for(int j = 0; j < countingArr[i]; j++)
                answer.add(min + i);

        return answer;
    }

    public static void tests()
    {
        int[] array = makeRandArr(25000, 1000000);
        System.out.println("Count sort time is: " + String.format("%.9f секунд", someSorts("count", array))); // O(n + k)
        System.out.println("Quick sort time is: " + String.format("%.9f секунд", someSorts("quick", array))); // O(n * logn)
    }

    public static void main(String[] args)
    {
        tests();
    }
}