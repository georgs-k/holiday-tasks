import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyBinaryTreeTest {

    private MyBinaryTree tree;

    @BeforeEach
    public void init() {
        int[] array = {4, 2, 1, 3, 6, 5, 7};
        tree = new MyBinaryTree();
        for (int i = 0; i < array.length; i++) tree.add(array[i]);
    }

    @Test
    public void testAdd() {
        assertFalse(tree.add(4));
        assertEquals(7, tree.getSize());
        assertTrue(tree.add(0));
        assertEquals(8, tree.getSize());
        assertTrue(tree.add(8));
        assertEquals(9, tree.getSize());
        assertEquals(0, tree.toArray()[0]);
        assertEquals(1, tree.toArray()[1]);
        assertEquals(2, tree.toArray()[2]);
        assertEquals(3, tree.toArray()[3]);
        assertEquals(4, tree.toArray()[4]);
        assertEquals(5, tree.toArray()[5]);
        assertEquals(6, tree.toArray()[6]);
        assertEquals(7, tree.toArray()[7]);
        assertEquals(8, tree.toArray()[8]);
    }

    @Test
    public void testContains() {
        tree.remove(1);
        assertFalse(tree.contains(1));
        assertTrue(tree.contains(4));
        assertFalse(tree.contains(0));
        assertFalse(tree.contains(8));
    }

    @Test
    public void testRemove() {
        assertFalse(tree.remove(0));
        assertEquals(7, tree.getSize());
        assertFalse(tree.remove(8));
        assertEquals(7, tree.getSize());
        assertTrue(tree.remove(1));
        assertEquals(6, tree.getSize());
        assertFalse(tree.remove(1));
        assertEquals(6, tree.getSize());
        assertTrue(tree.remove(6));
        assertEquals(5, tree.getSize());
        assertTrue(tree.remove(2));
        assertEquals(4, tree.getSize());
        assertTrue(tree.remove(7));
        assertEquals(3, tree.getSize());
        assertEquals(3, tree.toArray()[0]);
        assertEquals(4, tree.toArray()[1]);
        assertEquals(5, tree.toArray()[2]);
    }

    @Test
    public void testToArray() {
        assertEquals(1, tree.toArray()[0]);
        assertEquals(2, tree.toArray()[1]);
        assertEquals(3, tree.toArray()[2]);
        assertEquals(4, tree.toArray()[3]);
        assertEquals(5, tree.toArray()[4]);
        assertEquals(6, tree.toArray()[5]);
        assertEquals(7, tree.toArray()[6]);
        assertEquals(7, tree.toArray().length);
    }
}
