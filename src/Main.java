public class Main {
    public static void main(String[] args) {
        int[] myArray = {100, 46, 75, 6, 70, 23};
        MyBinaryTree tree = new MyBinaryTree();
        for (int i = 0; i < myArray.length; i++) System.out.print(myArray[i] + " ");
        System.out.println();
        for (int i = 0; i < myArray.length; i++) tree.add(myArray[i]);
        myArray = tree.toArray();
        for (int i = 0; i < tree.getSize(); i++) System.out.print(tree.toArray()[i] + " ");
        System.out.println();

        System.out.println(tree.remove(70));

        for (int i = 0; i < tree.getSize(); i++) System.out.print(tree.toArray()[i] + " ");
    }
}