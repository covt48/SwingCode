import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {
    private JPanel myPanel = new JPanel();
    private JLabel label_back = new JLabel();
    private JLabel label_plane = new JLabel();
    int cell = 64;



    public App(){
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(label_plane.getLocation().y>cell){
                        label_plane.setLocation(label_plane.getLocation().x,label_plane.getLocation().y-cell);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(label_plane.getLocation().y<592){
                        label_plane.setLocation(label_plane.getLocation().x,label_plane.getLocation().y+cell);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(label_plane.getLocation().x>cell){
                        label_plane.setLocation(label_plane.getLocation().x-cell,label_plane.getLocation().y);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(label_plane.getLocation().x<400){
                        label_plane.setLocation(label_plane.getLocation().x+cell,label_plane.getLocation().y);
                    }
                }
                System.out.print(label_plane.getLocation().x+","+label_plane.getLocation().y+"\n");
            }
        });


    }


    void start(){

        java.net.URL imgBack = App.class.getResource("img/background.png");
        label_back.setIcon(new ImageIcon(imgBack));
        label_back.setBounds(0,0,480,700);

        java.net.URL imgPlane = App.class.getResource("img/plane0.gif");
        label_plane.setIcon(new ImageIcon(imgPlane));
        label_plane.setBounds(208,592,64,64);

        myPanel.add(label_plane);
        myPanel.add(label_back);


        JFrame frame = new JFrame("测试");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,480,700);
        frame.setVisible(true);
        frame.setResizable(false);
        myPanel.setFocusable(true);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
