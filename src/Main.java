public class Main {
    public static void main(String[] args) {
        int[] myArray = {10, 23, 409, 1, 45, 23, 2342, 4564, 7657, 1231, 1, 4, 35, 543};
        for (int i = 0; i < myArray.length; i++) System.out.print(myArray[i] + " ");
        System.out.println();
        MyBubbleSort.sort(myArray);
        for (int i = 0; i < myArray.length; i++) System.out.print(myArray[i] + " ");
    }
}