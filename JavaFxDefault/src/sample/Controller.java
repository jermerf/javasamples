package sample;


import javafx.event.Event;
import javafx.scene.control.Button;

public class Controller {

    public void topLeft_clicked(Event ev) {
        Button btn = (Button) ev.getTarget();
        btn.setText("Ouch!");
    }

}
