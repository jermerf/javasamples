package stacksandqueue;

import java.util.ArrayList;
import java.util.List;

public class JerStack {
    private List<String> stack = new ArrayList<>();

    public void push(String item) {
        stack.add(item);
    }

    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    public int find(String search) {
        for(int i=0; i<stack.size(); i++) {
            String s = stack.get(i);
            if(search.equals(s)){
                return i;
            }
        }
        return -1;
    }


}
