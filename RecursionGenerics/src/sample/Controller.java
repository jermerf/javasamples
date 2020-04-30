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
import java.util.Map;

public class Controller {

    // Click the button
    public void doRecursion(Event ev){
        recursiveFunction(1);
    }

    // Recursive function
    public void recursiveFunction(int depth){
        System.out.println("Depth: " + depth);
        if(depth < 5) {
            recursiveFunction(depth + 1);
        }
        System.out.println("Depth: " + depth);
    }

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

    @FXML
    TextField txtFibIndex;

    public void startFib(Event ev){
        int index = Integer.parseInt(txtFibIndex.getText());
        System.out.println(fib(index));
    }

    public int fib(int index) {
        if(index == 0) return 0;
        if(index == 1) return 1;
        return fib(index-1) + fib(index-2);
    }


    // list

    @FXML
    TextField txtListItem;
    List<String> list = new ArrayList<>();

    public void addToList(Event ev) {
        list.add(txtListItem.getText());
        txtListItem.setText("");
    }
    public void showList(Event ev) {
        for(String s : list) {
            System.out.println(s);
        }
    }


    // Reading and Writing Files

    @FXML
    TextField txtToWrite;

    public void readFile(Event ev) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(windowFromEvent(ev));
        if(f == null){
            System.out.println("User cancelled");
        }else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));

                String text = "";
                String line = reader.readLine();

                while(line != null){
                    text += line + '\n';
                    line = reader.readLine();
                }
                reader.close();
                System.out.println(text);
            }catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }

        }
    }

    public void writeFile(Event ev) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(windowFromEvent(ev));
        if(f == null){
            System.out.println("User cancelled");
        }else {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                writer.write(txtToWrite.getText());
                writer.newLine();
                writer.write(txtToWrite.getText());
                writer.flush();
                writer.close();
            }catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }
}
