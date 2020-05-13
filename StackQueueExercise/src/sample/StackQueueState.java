package sample;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackQueueState implements Serializable {
    private List<String> queue;
    private List<String> stack;

    public StackQueueState(ObservableList<String> queueObs,
                           ObservableList<String> stackObs){
        queue = new ArrayList<>(queueObs);
        stack = new ArrayList<>(stackObs);
    }

    public List<String> getQueue() {
        return queue;
    }

    public List<String> getStack() {
        return stack;
    }
}
