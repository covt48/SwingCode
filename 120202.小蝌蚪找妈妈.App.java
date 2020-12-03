import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {
    private JPanel myPanel = new JPanel();
    private JLabel label_back = new JLabel();
    private JLabel label_mother = new JLabel();
    private JLabel label_son = new JLabel();
    private JLabel label_text = new JLabel();
    private JLabel label_exit = new JLabel();
    int cell = 64;



    public App(){
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(label_son.getY()>0){
                        label_son.setLocation(label_son.getX(),label_son.getY()-cell);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(label_son.getY()<768-cell){
                        label_son.setLocation(label_son.getX(),label_son.getY()+cell);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(label_son.getX()>0){
                        label_son.setLocation(label_son.getX()-cell,label_son.getY());}
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(label_son.getX()<1024-cell){
                        label_son.setLocation(label_son.getX()+cell,label_son.getY());}
                }
                if (label_son.getX() == label_mother.getX() && label_son.getY() == label_mother.getY()){
                    label_text.setVisible(true);
                    label_exit.setVisible(true);
                    label_son.setVisible(false);
                    label_mother.setVisible(false);
                    label_text.setText("You Win");
                    label_exit.setText("退出游戏");
                }
            }
        });
        label_text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                label_text.setVisible(false);
                label_exit.setVisible(false);
                label_son.setVisible(true);
                label_mother.setVisible(true);
                label_son.setBounds(0,0,64,64);
                label_mother.setBounds(((int)(Math.random()*16-1)+1)*64,((int)(Math.random()*12-1)+1)*64,64,64);
            }
        });
        label_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });


    }


    void start(){

        java.net.URL imgBack = App.class.getResource("img/background.png");
        label_back.setIcon(new ImageIcon(imgBack));
        label_back.setBounds(0,0,1024,768);

        java.net.URL imgSon = App.class.getResource("img/son.png");
        label_son.setIcon(new ImageIcon(imgSon));
        label_son.setBounds(0,0,64,64);

        java.net.URL imgMother = App.class.getResource("img/mother.png");
        label_mother.setIcon(new ImageIcon(imgMother));
        label_mother.setBounds(((int)(Math.random()*16-1)+1)*64,((int)(Math.random()*12-1)+1)*64,64,64);

        label_text.setFont(new Font("宋体", Font.BOLD,72));
        label_text.setBounds(330,150,400,200);
        label_text.setForeground(Color.red);
        label_text.setVisible(false);

        label_exit.setFont(new Font("宋体", Font.BOLD,72));
        label_exit.setBounds(330,350,400,200);
        label_exit.setForeground(Color.red);
        label_exit.setVisible(false);


        myPanel.add(label_text);
        myPanel.add(label_exit);
        myPanel.add(label_son);
        myPanel.add(label_mother);
        myPanel.add(label_back);


        JFrame frame = new JFrame("小蝌蚪找妈妈");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,768);
        frame.setVisible(true);
        frame.setResizable(false);
        myPanel.setFocusable(true);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
