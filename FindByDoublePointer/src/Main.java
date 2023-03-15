public class Main
{
    public static int[] input()
    {
        int[] seq = new int[] {1, 3, 7, 8};
        return seq;
    }

    public static int sumAnsw(int[] seq)
    {
        int k = 4;
        int ans = 0;
        int secondIndex = 0;
        for(int i = 0; i < seq.length; i++)
        {
            while(secondIndex < seq.length && seq[secondIndex] - seq[i] <= 4)
            {
                secondIndex++;
            }
            ans += seq.length - secondIndex;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(sumAnsw(input()));
    }
}