import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBubbleSortTest {

    @Test
    public void testSort() {
        int[] array = {4, 2, 1, 3, 6, 5, 7};
        MyBubbleSort.sort(array);
        assertEquals(7, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
        assertEquals(7, array[6]);
    }
}
