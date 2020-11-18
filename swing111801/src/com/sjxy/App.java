package com.sjxy;

import javax.swing.*;
import java.awt.*;

public class App {
    private JPanel myPanel;
    private JLabel label_img;

    void start(){
        label_img.setIcon(new ImageIcon("hxjzg.gif"));
        JFrame frame = new JFrame("App");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300,
                ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-240,600,480);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new App().start();
    }
}
