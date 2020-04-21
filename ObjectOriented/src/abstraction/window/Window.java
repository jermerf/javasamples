package abstraction.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JPanel content;
    private JButton btnYell;
    private JButton btnCalmDown;
    private JButton btnChill;
    private JTextField txtWords;

    private ActionListener calmListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Take a deep breath");
        }
    };

    public Window(String title){
        initializeProperties(title);
    }

    private void initializeProperties(String title){
        setTitle(title);
        // Create an object in place
        setSize(new Dimension(300, 400));
        // Or simply do this
        setSize(300, 400);
        content = new JPanel();
        setContentPane(content);

        btnYell = new JButton("Ahhh!");
        btnYell.addActionListener(new ButtonHandler());
        content.add(btnYell);

        btnCalmDown = new JButton("Calm Down");
        content.add(btnCalmDown);

        btnCalmDown.addActionListener(calmListener);

        btnChill = new JButton("Chillax");
        content.add(btnChill);
        btnChill.addActionListener(new ButtonHandler());
        btnChill.addActionListener(calmListener);

        txtWords = new JTextField();
        txtWords.setColumns(20);
        content.add(txtWords);
        btnChill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnChill.setText(txtWords.getText());
            }
        });
        setVisible(true);
    }
}
