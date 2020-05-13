package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller2 {

    @FXML
    TreeView fileBrowser;

    public void chooseFolder(Event ev){

        DirectoryChooser chooser = new DirectoryChooser();

        File f = chooser.showDialog(windowFromEvent(ev));
        if(f == null) {
            System.out.println("User cancelled");
        }else {
            System.out.println("Chose " + f.getAbsolutePath());
            TreeItem absoluteRoot = mapDirectory(f);
            fileBrowser.setRoot(absoluteRoot);
        }
    }

    public Window windowFromEvent(Event ev) {
        return ((Node)ev.getTarget()).getScene().getWindow();
    }

    public TreeItem mapDirectory(File root) {
        TreeItem item = new TreeItem(root.getName());

        // If file, return simple item
        if(root.isFile()) return item;

        //Must be directory, loop through each child
        File[] files = root.listFiles();

        for(File f : files) {
            TreeItem childItem = mapDirectory(f);
            item.getChildren().add(childItem);
        }
        return item;
    }

}
