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
        textArea_B.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    textArea_A.append("up!\n");
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    textArea_A.append("down!\n");
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    textArea_A.append("left!\n");
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    textArea_A.append("right!\n");
                }


            }
        });
    }




    void start(){
        label_back.setBounds(0,0,512,720);
        textArea_A.setBounds(100,100,200,150);
        textArea_B.setBounds(100,300,200,150);
        textArea_A.setBackground(Color.CYAN);
        textArea_B.setBackground(Color.YELLOW);

        myPanel.add(textArea_A);
        myPanel.add(textArea_B);
        myPanel.add(label_back);

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
