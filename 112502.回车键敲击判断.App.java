package com.sjxy;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {
    private JPanel myPanel = new JPanel();
    private JLabel label_back = new JLabel();
    private TextArea textArea_A = new TextArea();
    private TextArea textArea_B = new TextArea();


    public App(){
        textArea_A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(textArea_A.getText().equals("B")){
                        textArea_B.append("回答正确！\n");
                    }
                    else {
                        textArea_B.append("回答错误！\n");
                    }
                }

            }
        });
    }




    void start(){
        label_back.setBounds(0,0,512,720);
        textArea_A.setBounds(50,100,400,150);
        textArea_B.setBounds(50,300,400,150);
        textArea_A.setFont(new Font("Arial",Font.BOLD,14));
        textArea_B.setFont(new Font("Arial",Font.BOLD,14));
        textArea_A.setBackground(Color.CYAN);
        textArea_B.setBackground(Color.YELLOW);

        myPanel.add(textArea_A);
        myPanel.add(textArea_B);
        myPanel.add(label_back);
        textArea_B.setText("在路口等车时，下雨了谁最先知道？\n【A】交警\n【B】程序员\n【C】路人\n");

        JFrame frame = new JFrame("键盘监听事件");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,512,720);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
