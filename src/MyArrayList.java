public class MyArrayList {

    private int size;
    private Integer[] list = new Integer[4];

    private void doubleCapacity() {
        Integer[] largerList = new Integer[list.length * 2];
        for (int i = 0; i < list.length; i++) largerList[i] = list[i];
        list = largerList;
    }

    public int getSize() {
        return size;
    }

    // O(1)
    public void add(Integer value) {
        if (size == list.length) doubleCapacity();
        list[size++] = value;
    }

    // O(n)
    public void add(int index, Integer value) throws IndexOutOfBoundsException {
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
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }
}
