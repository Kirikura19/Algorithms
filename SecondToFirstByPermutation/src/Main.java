import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        String second = in.nextLine();
        if(second.length() != first.length())
        {
            System.out.println("No");
            System.exit(0);
        }


        List<String> firstList = new ArrayList<String>(Arrays.asList(first.split("")));
        List<String> secondList = new ArrayList<String>(Arrays.asList(second.split("")));

        int check = 0;
        for(int i = 0; i < firstList.stream().count(); i++)
        {
            if(secondList.contains(firstList.get(i)))
            {
                check += 1;
                secondList.remove(firstList.get(i));
            }
            else
            {
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");
    }
}