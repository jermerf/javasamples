package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;

public class Controller {
    private File chosen;
    @FXML
    private TextArea txtContent;


    public void newClicked() {
        txtContent.setText("");
    }

    public void openClicked(){

    }
    public void saveAsClicked(){

    }
    public void saveClicked(){

    }

}
