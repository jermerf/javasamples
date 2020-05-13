package sample;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;

public class Controller {
    private File chosen;
    @FXML
    private TextArea txtContent;

    private Window getWindowFromEvent(Event ev){
        return  ((Node)ev.getTarget()).getScene().getWindow();
    }

    public void newClicked() {
        txtContent.setText("");
    }

    public void openClicked(Event ev){
        FileChooser chooser = new FileChooser();
        chosen = chooser.showOpenDialog(getWindowFromEvent(ev));
        if(chosen == null) {
            return;
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(chosen));

                String line = reader.readLine();

                while(line != null) {
                    txtContent.appendText(line + "\n");
                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public void saveAsClicked(Event ev){
        FileChooser chooser = new FileChooser();
        chosen = chooser.showSaveDialog(getWindowFromEvent(ev));
        if(chosen == null) {
            return;
        } else {
            saveCurrentFile();
        }
    }
    public void saveClicked(Event ev){
        if(chosen == null) {
            saveAsClicked(ev);
        } else {
            saveCurrentFile();
        }
    }

    private void saveCurrentFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(chosen, false));
            writer.write(txtContent.getText());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
