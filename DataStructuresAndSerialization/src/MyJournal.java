
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyJournal {


    static class editor extends JFrame implements ActionListener {
        // Text component
        JTextArea t;

        // Frame
        JFrame f;

        editor() {

            f = new JFrame("Journal");

            try {
                // testing appearance
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

                MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            } catch (Exception e) {
            }

            // Text component
            t = new JTextArea();

            // menu
            JMenuBar mb = new JMenuBar();

            JMenu m1 = new JMenu("File");

            // file menu
            JMenuItem mi1 = new JMenuItem("New");
            JMenuItem mi2 = new JMenuItem("Open");
            JMenuItem mi3 = new JMenuItem("Save");
            JMenuItem mi9 = new JMenuItem("Print");

            mi1.addActionListener(this);
            mi2.addActionListener(this);
            mi3.addActionListener(this);
            mi9.addActionListener(this);

            m1.add(mi1);
            m1.add(mi2);
            m1.add(mi3);
            m1.add(mi9);

            JMenu m2 = new JMenu("Edit");

            // edit menu
            JMenuItem mi4 = new JMenuItem("cut");
            JMenuItem mi5 = new JMenuItem("copy");
            JMenuItem mi6 = new JMenuItem("paste");

            // action listeners
            mi4.addActionListener(this);
            mi5.addActionListener(this);
            mi6.addActionListener(this);

            m2.add(mi4);
            m2.add(mi5);
            m2.add(mi6);

            //close
            JMenuItem mc = new JMenuItem("close");

            mc.addActionListener(this);

            mb.add(m1);
            mb.add(m2);
            mb.add(mc);

            f.setJMenuBar(mb);
            f.add(t);
            f.setSize(500, 500);
            f.show();
        }

        // If a button is pressed
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();

            if (s.equals("cut")) {
                t.cut();
            } else if (s.equals("copy")) {
                t.copy();
            } else if (s.equals("paste")) {
                t.paste();
            } else if (s.equals("Save")) {

                JFileChooser j = new JFileChooser("f:");

                // save
                int r = j.showSaveDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {


                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);

                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);

                        // Write
                        w.write(t.getText());

                        w.flush();
                        w.close();
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // if cancelled
                else
                    JOptionPane.showMessageDialog(f, "Cancelled");
            } else if (s.equals("Print")) {
                try {
                    // print the file
                    t.print();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            } else if (s.equals("Open")) {
                // JFileChooser class
                JFileChooser j = new JFileChooser("f:");

                // showsOpenDialog function
                int r = j.showOpenDialog(null);

                // select file
                if (r == JFileChooser.APPROVE_OPTION) {
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        String s1 = "", sl = "";
                        FileReader fr = new FileReader(fi);
                        BufferedReader br = new BufferedReader(fr);

                        sl = br.readLine();

                        // input from file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Set the text
                        t.setText(sl);
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If cancelled
                else
                    JOptionPane.showMessageDialog(f, "Cancelled");
            } else if (s.equals("New")) {
                t.setText("");
            } else if (s.equals("close")) {
                f.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        editor e = new editor();
    }
}
