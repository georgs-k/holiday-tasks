import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayListTest {

    private MyArrayList list;

    @BeforeEach
    public void init() {
        int[] array = {1, 2, 3, 4};
        list = new MyArrayList();
        for (int i = 0; i < array.length; i++) list.add(array[i]);
    }

    @Test
    public void testAdd() {
        assertEquals(4, list.getSize());
        list.add(5);
        assertEquals(5, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    public void testAddWithInsertion() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 5));
        assertEquals(4, list.getSize());
        list.add(1, 5);
        assertEquals(5, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    public void testDelete() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(4));
        assertEquals(4, list.getSize());
        list.delete(1);
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    public void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
        assertEquals(4, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }
}
