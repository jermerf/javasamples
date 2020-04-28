package sample;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    Button btnPink;

    public void btnPink_action(Event ev) {
        Button clickedButton = (Button) ev.getTarget();
        if(btnPink == clickedButton) {
            btnPink.setText("I have been clicked!");
        }else {
            clickedButton.setText("I wish I were pink!");
            btnPink.setText("It's so #FFAABB!");
        }
    }

}
