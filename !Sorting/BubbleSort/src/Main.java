import java.util.Arrays;

public class Main
{
    public static int[] BubbleSort(int[] array) {
        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]) {
                    Swap(array, i, i+1);
                    needIteration = true;
                }
            }
        }
        return array;
    }

    public static void Swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(BubbleSort(new int[] {9, 8, 7, 9, 9, 9, 999, 1, 2, 3, 1, 2, 3, 99})));
    }
}