import java.util.Arrays;

public class Main {
    public static int[] SelectionSorting(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j < array.length; j++) {
                if(array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            Swap(array, i, minIndex);
        }
        return array;
    }
    public static void Swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(SelectionSorting(new int[] {9, 8, 7, 9, 9, 9, 999, 1, 2, 3, 1, 2, 3, 99})));
    }
}