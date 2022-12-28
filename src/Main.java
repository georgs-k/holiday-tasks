public class Main {
    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();

        list.add(22);
        list.add(44);
        list.add(66);
        list.add(22);

        for (int i = 0; i < list.getSize(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
        System.out.println(list.getSize());

        list.delete(3);

        for (int i = 0; i < list.getSize(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
        System.out.println(list.getSize());
        System.out.println();
        System.out.println(list.get(2));

    }
}