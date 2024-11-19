
public class Main {
    public static void main(String[] args) {
        // write testcode here

    }
    public static int smallest (int[] array) {
        int smallestNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallestNumber) {
                smallestNumber = array[i];
            }
        }
        return smallestNumber;
    }

    public static int indexOfSmallest (int[] array) {
        int smallestNumber = array[0];
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallestNumber) {
                smallestNumber = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
