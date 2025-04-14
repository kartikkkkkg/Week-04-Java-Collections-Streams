import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    private final ListManager manager = new ListManager();
    private final List<Integer> list = new ArrayList<>();

    @Test
    void testAddElement() {
        manager.addElement(list, 1);
        assertEquals(1, list.size());
        assertTrue(list.contains(1));
    }

    @Test
    void testRemoveElement() {
        list.add(1);
        manager.removeElement(list, 1);
        assertEquals(0, list.size());
    }

    @Test
    void testGetSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}