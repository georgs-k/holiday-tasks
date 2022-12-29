public class MyMergeSort {

    // O(n * log n))
    public static void sort(int[] array) {
        if (array.length < 2) return;
        int middle = array.length / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[array.length - middle];
        for (int i = 0; i < leftHalf.length; i++) leftHalf[i] = array[i];
        for (int i = 0; i < rightHalf.length; i++) rightHalf[i] = array[i + middle];
        sort(leftHalf);
        sort(rightHalf);
        int nextLeftElement = 0;
        int nextRightElement = 0;
        do {
            if (nextLeftElement < leftHalf.length && nextRightElement < rightHalf.length) {
                if (leftHalf[nextLeftElement] < rightHalf[nextRightElement]) {
                    array[nextLeftElement + nextRightElement] = leftHalf[nextLeftElement];
                    nextLeftElement++;
                }
                else {
                    array[nextLeftElement + nextRightElement] = rightHalf[nextRightElement];
                    nextRightElement++;
                }
            }
            else {
                if (nextLeftElement < leftHalf.length) {
                    array[nextLeftElement + nextRightElement] = leftHalf[nextLeftElement];
                    nextLeftElement++;
                }
                else {
                    array[nextLeftElement + nextRightElement] = rightHalf[nextRightElement];
                    nextRightElement++;
                }
            }
        } while (nextLeftElement < leftHalf.length || nextRightElement < rightHalf.length);
    }
}
