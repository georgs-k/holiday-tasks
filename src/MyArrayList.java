public class MyArrayList {

    private int size;
    private int[] list = new int[4];

    private void doubleCapacity() {
        int[] largerList = new int[list.length * 2];
        for (int i = 0; i < list.length; i++) largerList[i] = list[i];
        list = largerList;
    }

    public int getSize() {
        return size;
    }

    // O(1)
    public void add(int value) {
        if (size == list.length) doubleCapacity();
        list[size++] = value;
    }

    // O(n)
    public void add(int index, int value) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        if (size == list.length) doubleCapacity();
        for (int i = size - 1; i >= index; i--) list[i + 1] = list[i];
        size++;
        list[index] = value;
    }

    // O(n)
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) list[i] = list[i + 1];
        size--;
    }

    // O(1)
    public int get(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }
}
