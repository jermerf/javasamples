package sample;


import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

public class Controller {
    private static final String SAVE_FILE = "state.dat";
    @FXML
    private TextField txtQueue;
    @FXML
    private TextField txtStack;
    @FXML
    private ListView listQueue;
    @FXML
    private ListView listStack;

    public void enqueue(Event ev){
        listQueue.getItems().add(txtQueue.getText());
        txtQueue.setText("");
    }
    public void dequeue(Event ev){
        if(listQueue.getItems().size() == 0) return;
        String removed = (String)listQueue.getItems().remove(0);
        txtQueue.setText(removed);
    }
    public void push(Event ev){
        listStack.getItems().add(txtStack.getText());
        txtStack.setText("");
    }
    public void pop(Event ev){
        int lastIndex = listStack.getItems().size() - 1;
        if(lastIndex < 0) return;
        String removed = (String)listStack.getItems().remove(lastIndex);
        txtStack.setText(removed);
    }

    public void load(Event ev){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(SAVE_FILE));
            StackQueueState state = (StackQueueState) input.readObject();
            input.close();
            listQueue.setItems(FXCollections.observableList(state.getQueue()));
            listStack.setItems(FXCollections.observableList(state.getStack()));
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void save(Event ev){
        StackQueueState state = new StackQueueState(listQueue.getItems(), listStack.getItems());

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
            output.writeObject(state);
            output.flush();
            output.close();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
