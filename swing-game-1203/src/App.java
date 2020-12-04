import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {
    //需要用到的swing控件
    private JPanel myPanel = new JPanel();
    private  JLabel label_forg1 = new JLabel();
    private  JLabel label_forg2 = new JLabel();
    private  JLabel label_forg3 = new JLabel();
    private  JLabel label_word1 = new JLabel();
    private  JLabel label_word2 = new JLabel();
    private  JLabel label_word3 = new JLabel();
    private  JLabel label_back = new JLabel();
    private  JLabel label_score = new JLabel();
    private  JLabel label_win = new JLabel();
    private JTextArea textArea_A = new JTextArea();
    private int num = 1;//用于记录当前过河的青蛙
    private int step = 0;//用于控制不允许跨步过河
    private int score = 3;//记录剩余几只青蛙没过河
    private int ranNum;//用于随机选择地图

    private String array2d_gameMap[][]={//游戏地图
            {"hello","world","hi"},
            {"morning","afternoon","night"},
            {"tomy","jery","uncle"},
            {"abc","def","ghi"},
            {"345","678","123"}
    };


    public App(){
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                textArea_A.append(String.valueOf(e.getKeyChar()));
                JLabel label = num==1?label_forg1:num==2?label_forg2:label_forg3;//三目运算，根据num的值确定哪只青蛙过河
                if(textArea_A.getText().contains(label_word1.getText()) && step==0){
                    label.setLocation(405,290);
                    textArea_A.setText("");
                    step=1;
                }
                else if(textArea_A.getText().contains(label_word2.getText()) && step==1){
                    label.setLocation(270,110);
                    textArea_A.setText("");
                    step=2;
                }
                else if(textArea_A.getText().contains(label_word3.getText()) && step==2){
                    if(num == 1){
                        label.setLocation(920,20);
                    }else if(num == 2){
                        label.setLocation(700,20);
                    }else{
                        label.setLocation(570,20);
                    }
                    textArea_A.setText("");
                    step=0;
                    num ++;
                    score--;
                    label_score.setText("剩余青蛙："+score);
                    if(score == 0){
                        myPanel.removeAll();
                        myPanel.add(label_win);
                        myPanel.add(label_back);
                        label_win.setText("游戏成功！");
                        myPanel.repaint();
                    }
                }
            }
        });
        myPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.print(e.getX()+","+e.getY()+"\n");//控制台输出鼠标点击的坐标，方便调试
            }
        });
        label_win.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myPanel.removeAll();

                myPanel.add(label_forg1);
                myPanel.add(label_forg2);
                myPanel.add(label_forg3);
                myPanel.add(label_word1);
                myPanel.add(label_word2);
                myPanel.add(label_word3);
                myPanel.add(label_score);
                myPanel.add(label_back);

                myPanel.repaint();


                num = 1;//用于记录当前过河的青蛙
                score = 3;//记录剩余几只青蛙没过河

                ranNum = (int)(Math.random()*(array2d_gameMap.length-1));
                label_word1.setText(array2d_gameMap[ranNum][0]);
                label_word2.setText(array2d_gameMap[ranNum][1]);
                label_word3.setText(array2d_gameMap[ranNum][2]);


                label_forg1.setBounds(70,420,128,128);
                label_forg2.setBounds(200,420,128,128);
                label_forg3.setBounds(330,420,128,128);
                label_score.setText("剩余青蛙："+score);
            }
        });


    }




    void start(){
        java.net.URL imgBack = App.class.getResource("img/backgroundpro.png");
        label_back.setIcon(new ImageIcon(imgBack));
        label_back.setBounds(0,0,1024,600);

        java.net.URL imgForg = App.class.getResource("img/frog.png");
        label_forg1.setIcon(new ImageIcon(imgForg));
        label_forg1.setBounds(70,420,128,128);

        label_forg2.setIcon(new ImageIcon(imgForg));
        label_forg2.setBounds(200,420,128,128);


        label_forg3.setIcon(new ImageIcon(imgForg));
        label_forg3.setBounds(330,420,128,128);

        textArea_A.setBounds(0,0,150,30);
        textArea_A.setVisible(false);

        label_score.setBounds(0,0,150,50);
        label_score.setFont(new Font("宋体", Font.BOLD,24));
        label_score.setForeground(Color.black);
        label_score.setText("剩余青蛙："+score);

        label_win.setFont(new Font("宋体", Font.BOLD,72));
        label_win.setBounds(300,150,400,200);
        label_win.setForeground(Color.red);
        label_win.setText("游戏成功！");

        label_word1.setFont(new Font("宋体", Font.BOLD,48));
        label_word1.setBounds(380,280,250,150);
        label_word1.setForeground(Color.black);

        label_word2.setFont(new Font("宋体", Font.BOLD,48));
        label_word2.setBounds(230,100,250,150);
        label_word2.setForeground(Color.black);

        label_word3.setFont(new Font("宋体", Font.BOLD,48));
        label_word3.setBounds(530,0,250,150);
        label_word3.setForeground(Color.black);


        ranNum = (int)(Math.random()*(array2d_gameMap.length-1));
        label_word1.setText(array2d_gameMap[ranNum][0]);
        label_word2.setText(array2d_gameMap[ranNum][1]);
        label_word3.setText(array2d_gameMap[ranNum][2]);


        myPanel.add(label_forg1);
        myPanel.add(label_forg2);
        myPanel.add(label_forg3);
        myPanel.add(label_word1);
        myPanel.add(label_word2);
        myPanel.add(label_word3);
        myPanel.add(textArea_A);
        myPanel.add(label_score);
        myPanel.add(label_back);


        JFrame frame = new JFrame("青蛙过河");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,600);
        frame.setVisible(true);
        frame.setResizable(false);
        myPanel.setFocusable(true);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
