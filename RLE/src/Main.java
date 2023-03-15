import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static List<String> RLE(String seq)
    {
        String[] seqArr = seq.split("");
        List<String> answer = new ArrayList<>();
        int q = 1;
        for(int i = 1; i < seqArr.length; i++)
        {
            if(seqArr[i-1].equals(seqArr[i]))
                q+=1;
            else
            {
                if (q == 1)
                    answer.add(seqArr[i-1]);
                else
                {
                    answer.add(q + seqArr[i-1]);
                    q = 1;
                }

            }
        }
        return answer;
    }
    public static void main(String[] args)
    {
        String seq = "AAAAAAAAAAAABBHHHHHHHHHSSSSDDDDDDFDCCCCKKKKKKKLLLLZZZZ";
        List<String> answer = RLE(seq);
        System.out.println(answer.toString());
    }
}