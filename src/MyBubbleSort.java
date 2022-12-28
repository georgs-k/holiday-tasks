public class MyBubbleSort {

    // O(n^2)
    public static void sort(int[] array) {
        int topIndex = array.length - 1;
        if (topIndex < 1) return;
        int swapBuffer;
        boolean isSorted;
        for (int sortedPortionLimit = 0; sortedPortionLimit < topIndex; sortedPortionLimit++) {
            isSorted = true;
            for (int i = topIndex - 1; i >= sortedPortionLimit; i--) {
                if (array[i] > array[i + 1]) {
                    swapBuffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swapBuffer;
                    if (isSorted) isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }
}
