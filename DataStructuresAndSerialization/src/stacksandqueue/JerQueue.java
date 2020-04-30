package stacksandqueue;

import java.util.ArrayList;
import java.util.List;

public class JerQueue {
    private List<String> queue = new ArrayList<>();

    public void enqueue(String item) {
        queue.add(item);
    }

    public String dequeue() {
        return queue.remove(0);
    }

}
