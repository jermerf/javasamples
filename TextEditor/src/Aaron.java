package sample;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Queue;

public class Aaron extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Queue and Dequeue");
        TextArea ta1 = new TextArea();
        TextArea ta2 = new TextArea();
        Button q = new Button("Queue");
        Button d = new Button("Dequeue");
        Button pu = new Button("Push");
        Button po = new Button("Pop");
        Button s = new Button("Save");
        Button l = new Button("Load");
        q.setMinWidth(50);
        String t1 = ta1.getText();
        Queue<String>queue = new LinkedList<>();
        queue.add(t1);
        ListView list = new ListView();
        ObservableList<String> items = list.getItems();

        q.setOnAction(action -> {
            items.add(ta1.getText());
            ta1.setText("");
        });
        d.setOnAction(action -> {
            System.out.println(items.remove(0));
        });

        VBox vbox = new VBox(ta1, q, d, ta2, pu, list);
        Scene scene = new Scene(vbox, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}