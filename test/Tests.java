import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {


    @Test
    public void firstTest(){
        NaryTree tree = new NaryTree(5);
        assertTrue(tree.isEmpty());
        tree.add(5);
        tree.add(10);
        tree.add(15);
        tree.add(9);
        tree.add(8);
        tree.add(20);
        assertEquals(6, tree.size);
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(8));
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(1));
    }

    @Test
    public void secondTest(){
        NaryTree tree = new NaryTree(6);
        assertTrue(tree.isEmpty());
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(101);
        tree.add(1104);
        tree.add(200);
        tree.add(199);
        assertEquals(8, tree.size);
        assertTrue(tree.contains(199));
        assertTrue(tree.contains(1104));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(40));
        assertFalse(tree.contains(9));
    }

    @Test
    public void thirdTest(){
        NaryTree tree = new NaryTree(5);
        HashSet<Integer> set = new HashSet<>();
        set.add(32);
        set.add(8);
        set.add(17);
        set.add(23);
        set.add(63);
        set.add(33);
        set.add(42);
        set.add(51);
        set.add(59);
        set.add(37);
        set.add(39);
        set.add(44);
        set.add(45);
        set.add(48);
        set.add(50);
        set.add(46);
        set.add(84);
        set.add(71);
        set.add(78);
        set.add(91);
        set.add(103);
        assertTrue(tree.isEmpty());
        tree.add(32);
        tree.add(8);
        tree.add(17);
        tree.add(23);
        tree.add(63);
        tree.add(33);
        tree.add(42);
        tree.add(51);
        tree.add(59);
        tree.add(37);
        tree.add(39);
        tree.add(44);
        tree.add(45);
        tree.add(48);
        tree.add(50);
        tree.add(46);
        tree.add(84);
        tree.add(71);
        tree.add(78);
        tree.add(91);
        tree.add(103);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertEquals(21, tree.size);
        assertTrue(tree.contains(44));
        assertTrue(tree.contains(103));
        assertFalse(tree.contains(77));
        assertFalse(tree.contains(99));

        tree.remove(46);
        set.remove(46);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(46));
        assertEquals(20, tree.size);

        tree.remove(42);
        set.remove(42);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(42));
        assertEquals(19, tree.size);

        tree.remove(91);
        set.remove(91);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(91));
        assertEquals(18, tree.size);

        tree.remove(8);
        set.remove(8);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertEquals(set.size(), tree.size);
        assertFalse(tree.contains(8));

        tree.remove(78);
        set.remove(78);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(78));
        assertEquals(16, tree.size);

        tree.remove(63);
        set.remove(63);
        for (Integer i : set) {
            assertTrue(tree.contains(i));
        }
        assertFalse(tree.contains(63));
        assertEquals(15, tree.size);
    }
}