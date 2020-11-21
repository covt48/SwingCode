
import sun.audio.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class App{
    private JPanel myPanel = new JPanel();
    private JLabel label_img = new JLabel();
    private JLabel label_background = new JLabel();
    private JLabel label_startBackground = new JLabel();
    private JLabel label_score = new JLabel();
    private JLabel label_yourscore = new JLabel();
    private JLabel label_start = new JLabel();
    private JLabel label_end = new JLabel();
    private int[] x = {190,440,690,160,440,690,150,440,720};//9个树洞的X坐标
    private int[] y = {235,230,235,375,375,375,530,530,530};//9个树洞的Y坐标
    private int ran_num = (int)(Math.random()*x.length);//随机选择坐标

    private int score = 0;//成绩
    private int click = 0;//统计点击错误次数

    //初始化变量
    private Date before=new Date();
    private Date now=new Date();
    private int t = 0;
    private boolean status = true;


    //点击错误音效
//    InputStream inputStream1 = new FileInputStream(new File("src/error.wav"));
    InputStream inputStream1 = getClass().getResourceAsStream("error.wav");
    //点击成功音效
//    InputStream inputStream2 = new FileInputStream(new File("src/success.wav"));
    InputStream inputStream2 = getClass().getResourceAsStream("success.wav");
    //游戏失败音效W
//    InputStream inputStream3 = new FileInputStream(new File("src/lose.wav"));
    InputStream inputStream3 = getClass().getResourceAsStream("lose.wav");
    //游戏开始音效
//    InputStream inputStream4 = new FileInputStream(new File("src/start.wav"));
    InputStream inputStream4 = getClass().getResourceAsStream("start.wav");


    public App() throws FileNotFoundException {
            label_start.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    click = 0;
                    score = 0;
                    before = new Date();
                    status = false;
                    t=0;
                    label_score.setLocation(50,-30);
                    label_score.setSize(200,100);
                    label_score.setFont(new Font("Arial", Font.BOLD,24));
                    label_score.setText("Your Score:"+String.valueOf(score));//设置分数显示
                    label_background.setVisible(true);
                    label_img.setVisible(true);
                    label_startBackground.setVisible(false);
                    label_start.setVisible(false);
                    label_end.setVisible(false);
                    label_yourscore.setVisible(false);
                    try {//调用游戏启动音效
                        new App().gameStart();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            label_end.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.exit(0);
                }
            });
            label_img.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    try {//调用点击成功音效
                        new App().success();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    score += 10;//分数增加，10/次
                    label_score.setText("Your Score:"+String.valueOf(score));//设置分数显示
                    int last_ranNum = ran_num;//记录上一次随机坐标
                    do {//如果重新随机的坐标与上一次坐标相同，则重新随机坐标
                        ran_num = (int)(Math.random()*x.length);
                    }while (last_ranNum==ran_num);
                    //变换地鼠坐标
                    label_img.setLocation(x[ran_num],y[ran_num]);
                    before = new Date();
                }
            });
            label_background.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    label_score.setText("Your Score:"+String.valueOf(score));
                    click++;//记录点击失败次数增加timer.cancel();//定时器取消
                    before = new Date();
                    if(click<5){//5次以内的点击失败次数，提示错误音效
                        try {//调用点击错误音效
                            new App().error();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if(click>=5){//达到5次点击失败，游戏结束，提示游戏结束音效
                        try {//调用游戏失败音效
                            new App().lose();
                            label_score.setLocation(300,150);
                            label_score.setSize(400,150);
                            label_score.setFont(new Font("Arial", Font.BOLD,64));
                            label_score.setText("Game Over!");//分数栏显示设置
                            label_yourscore.setText("Your Score:"+score);
                            label_background.setVisible(false);
                            label_startBackground.setVisible(true);
                            label_yourscore.setVisible(true);
                            label_start.setVisible(true);
                            label_end.setVisible(true);
                            label_start.setLocation(300,350);
                            label_end.setLocation(300,470);
                            status = true;
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

    }




    void error(){
        //点击错误提示音效
        AudioPlayer.player.start(inputStream1);
    }
    void success(){
        //点击成功提示音效
        AudioPlayer.player.start(inputStream2);
    }
    void lose(){
        //游戏结束音效
        AudioPlayer.player.start(inputStream3);
    }
    void gameStart(){
        //游戏启动音效
        AudioPlayer.player.start(inputStream4);

    }


    void start() throws FileNotFoundException {

        /*设置鼠标光标变成图片*/
        Toolkit tk = Toolkit.getDefaultToolkit();
        java.net.URL imgUrlmouse = App.class.getResource("hammer.gif");
        Image img = tk.createImage(imgUrlmouse);
        Cursor cu = tk.createCustomCursor(img,new Point(20,10),"stick");



        java.net.URL imgStrat = App.class.getResource("start.gif");
        label_start.setIcon(new ImageIcon(imgStrat));
        java.net.URL imgEnd = App.class.getResource("end.gif");
        label_end.setIcon(new ImageIcon(imgEnd));
        java.net.URL imgStart = App.class.getResource("background.gif");
        label_startBackground.setIcon(new ImageIcon(imgStart));
        java.net.URL imgUrl_mouse = App.class.getResource("mouse.gif");
        label_img.setIcon(new ImageIcon(imgUrl_mouse));
        java.net.URL imgUrl_bg = App.class.getResource("background.gif");
        label_background.setIcon(new ImageIcon(imgUrl_bg));
        myPanel.setLayout(null);
        /*add顺序不要错乱*/
        myPanel.add(label_start);
        myPanel.add(label_end);
        myPanel.add(label_score);
        myPanel.add(label_yourscore);
        myPanel.add(label_startBackground);
        myPanel.add(label_img);
        myPanel.add(label_background);



        label_img.setBounds(x[ran_num],y[ran_num],100,80);
        label_background.setBounds(0,0,1024,768);
        label_startBackground.setBounds(0,0,1024,768);
        label_start.setBounds(300,200,350,100);
        label_end.setBounds(300,320,350,100);
        label_score.setBounds(50,-30,200,100);
        label_yourscore.setBounds(380,250,200,100);
        label_score.setFont(new Font("Arial", Font.BOLD,24));
        label_yourscore.setFont(new Font("Arial", Font.BOLD,24));
        label_score.setForeground(Color.RED);
        label_yourscore.setForeground(Color.RED);
        //设置地鼠不显示
        label_img.setVisible(false);
        label_background.setVisible(false);
        label_yourscore.setVisible(false);
        //初始化点击数
        click=0;

        JFrame frame = new JFrame("打地鼠 V2.0");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口启动时显示在屏幕正中间
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-512,
                ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-360,
                1024,720);
        frame.setVisible(true);
        frame.setResizable(false);//设置不给拖动窗口大小

        //把上面修改的鼠标样式设置给frame窗口
        frame.setCursor(cu);

        while(t<=2 || status)//循环条件,3秒没有鼠标点击则结束
        {
            // 计算循环总时长
            now = new Date();
            // 现在的时间减去开始的时间可以计算出来使用的时间
            t = (int)((now.getTime() - before.getTime())/1000);
            System.out.println(t);
            System.out.println(now);
            //System.out.println(String.valueOf(voiceError));
        }
        try {//调用游戏失败音效
            new App().lose();
            label_score.setLocation(300,150);
            label_score.setSize(400,150);
            label_score.setFont(new Font("Arial", Font.BOLD,64));
            label_score.setText("Game Over!");//分数栏显示设置
            label_yourscore.setText("Your Score:"+score);
            label_background.setVisible(false);
            label_startBackground.setVisible(true);
            label_yourscore.setVisible(true);
            label_start.setVisible(true);
            label_end.setVisible(true);
            label_start.setLocation(300,350);
            label_end.setLocation(300,470);
            status = true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new App().start();
    }
}
