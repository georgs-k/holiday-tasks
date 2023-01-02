import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyLinkedListTest {

    private MyLinkedList list;

    @BeforeEach
    public void init() {
        int[] array = {1, 2, 3, 4, 5};
        list = new MyLinkedList();
        for (int i = 0; i < array.length; i++) list.add(array[i]);
    }

    @Test
    public void testAdd() {
        assertEquals(5, list.getSize());
        list.add(6);
        assertEquals(6, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
    }

    @Test
    public void testAddWithInsertion() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(6, 6));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, -1));
        assertEquals(5, list.getSize());
        list.add(5, 6);
        assertEquals(6, list.getSize());
        list.add(0, 0);
        assertEquals(7, list.getSize());
        list.add(2, 7);
        assertEquals(8, list.getSize());
        list.add(6, 8);
        assertEquals(9, list.getSize());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(7, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(3, list.get(4));
        assertEquals(4, list.get(5));
        assertEquals(8, list.get(6));
        assertEquals(5, list.get(7));
        assertEquals(6, list.get(8));
    }

    @Test
    public void testDelete() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertEquals(5, list.getSize());
        list.delete(1);
        assertEquals(4, list.getSize());
        list.delete(2);
        assertEquals(3, list.getSize());
        list.delete(0);
        assertEquals(2, list.getSize());
        list.delete(1);
        assertEquals(1, list.getSize());
        list.delete(0);
        assertEquals(0, list.getSize());
    }

    @Test
    public void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertEquals(5, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }
}
