import java.util.Arrays;

public class Main {

    public static int[] input()
    {
        int[] arr = new int[]{16, 103, 44, 55, 2, 107, 809, 666};

        return arr;
    }

    public static int findRazr()
    {
        int max = Arrays.stream(input()).max().getAsInt();
        int count = 0;
        while(max != 0)
        {
            max = max / 10;
            count += 1;
        }
        return count;
    }

    public static void Radix()
    {
        int[] inArr = input();
        int razr = findRazr();

        for(int i = 1; i <= findRazr(); i = i * 10)
        {
            int[][] temp = new int [10][inArr.length];
            for(int j = 0; j < inArr.length; j++)
            {
                int tempQ = (inArr[j]/i)%10;
                temp[tempQ][j] = inArr[j];
            }

        }



    }

    public static void main(String[] args)
    {
        Radix();
    }
}