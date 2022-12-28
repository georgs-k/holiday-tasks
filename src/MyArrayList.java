public class MyArrayList {

    private int size;
    private Integer[] list = new Integer[4];

    private void doubleCapacity() {
        Integer[] largerList = new Integer[list.length * 2];
        System.arraycopy(list, 0, largerList, 0, list.length);
        list = largerList;
    }

    public int getSize() {
        return size;
    }

    public void add(Integer value) {
        if (size == list.length) doubleCapacity();
        list[size++] = value;
    }

    public void add(int index, Integer value) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        if (size == list.length) doubleCapacity();
        for (int i = size - 1; i >= index; i--) list[i + 1] = list[i];
        size++;
        list[index] = value;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) list[i] = list[i + 1];
        size--;
    }

    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }
}
