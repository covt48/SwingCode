import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {
    private JPanel myPanel = new JPanel();
    private JLabel label_img = new JLabel();
    private JLabel label_background = new JLabel();
    private JLabel label_score = new JLabel();
    private int[] x = {190,440,690,160,440,690,150,440,720};
    private int[] y = {235,230,235,375,375,375,530,530,530};

    private int score = 0;

    public App() {
            label_img.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    score+=10;
                    label_score.setText("Your Score:"+String.valueOf(score));
                    int ran_num = (int)(Math.random()*x.length);
                    label_img.setLocation(x[ran_num],y[ran_num]);
                }
            });

    }



    void start(){
        java.net.URL imgUrl1 = App.class.getResource("mouse.gif");
        label_img.setIcon(new ImageIcon(imgUrl1));
        java.net.URL imgUrl2 = App.class.getResource("background.gif");
        label_background.setIcon(new ImageIcon(imgUrl2));
        myPanel.setLayout(null);
        myPanel.add(label_img);
        myPanel.add(label_score);
        myPanel.add(label_background);



        int ran_num = (int)(Math.random()*x.length);
        label_img.setBounds(x[ran_num],y[ran_num],100,80);
        label_background.setBounds(0,0,1024,768);
        label_score.setBounds(50,-30,200,100);
        label_score.setFont(new Font("宋体", Font.BOLD,24));
        label_score.setForeground(Color.RED);

        JFrame frame = new JFrame("打地鼠 V1.0");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,720);
        frame.setVisible(true);
        frame.setResizable(false);//设置不给拖动窗口大小
    }
    public static void main(String[] args) {
        new App().start();
    }
}
