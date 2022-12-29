public class Main {
    public static void main(String[] args) {
        int[] myArray = {95, 45, 0, -4, 24, 59};
        for (int i = 0; i < myArray.length; i++) System.out.print(myArray[i] + " ");
        System.out.println();
        MyMergeSort.sort(myArray);
        for (int i = 0; i < myArray.length; i++) System.out.print(myArray[i] + " ");
    }
}