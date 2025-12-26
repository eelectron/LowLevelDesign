package skipList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved JUnit tests for Skiplist class.
 */
public class SkipListTest {

   private Skiplist skiplist;

   @BeforeEach
   public void setUp() {
       skiplist = new Skiplist();
   }

   @Test
   public void testAddAndSearch() {
       skiplist.add(1);
       skiplist.add(2);
       skiplist.add(3);
       assertFalse(skiplist.search(0), "Expected false for search(0)");
       skiplist.add(4);
       assertTrue(skiplist.search(1), "Expected true for search(1)");
       skiplist.add(5);
       assertTrue(skiplist.search(3), "Expected true for search(3)");
       assertFalse(skiplist.search(6), "Expected false for search(6)");
   }

   @Test
   public void testEmptySkiplist() {
       assertFalse(skiplist.search(10), "Expected false for search(10) in empty skiplist");
   }

   @Test
   public void testEraseExistingAndNonExisting() {
       skiplist.add(10);
       skiplist.add(20);
       assertTrue(skiplist.search(10), "10 should be present before erase");
       assertTrue(skiplist.erase(10), "erase should return true for existing element");
       assertFalse(skiplist.search(10), "10 should no longer be found after erase");
       assertFalse(skiplist.erase(30), "erase should return false for non-existing element");
   }

   @Test
   public void testDuplicateAddsAndEraseRemovesAll() {
       skiplist.add(7);
       skiplist.add(7);
       assertTrue(skiplist.search(7), "Expected true for search(7) after adding duplicates");
       // erase should remove all occurrences of 7
       assertTrue(skiplist.erase(7), "erase should return true when removing existing duplicates");
       assertFalse(skiplist.search(7), "7 should not be found after erase");
   }

   @Test
   public void testManyAddsAndSearch() {
       for (int i = 0; i < 100; i++) {
           skiplist.add(i * 2);
       }
       for (int i = 0; i < 100; i++) {
           assertTrue(skiplist.search(i * 2), "Expected to find " + (i * 2));
           assertFalse(skiplist.search(i * 2 + 1), "Did not expect to find " + (i * 2 + 1));
       }
   }
}
