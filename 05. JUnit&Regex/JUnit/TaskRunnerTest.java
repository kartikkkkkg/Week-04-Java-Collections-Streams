import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

class TaskRunnerTest {
    private final TaskRunner runner = new TaskRunner();

    @Test
    @Timeout(2)
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Done", runner.longRunningTask());
    }
}