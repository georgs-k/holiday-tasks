public class Main {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.add(22);
        list.add(44);
        list.add(66);
        list.add(22);

        System.out.println(list);

        list.add(2L, 44444);

        System.out.println(list);

        list.delete(2L);

        System.out.println(list);

        System.out.println(list.get(2L));

    }
}