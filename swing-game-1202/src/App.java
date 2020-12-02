import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

    private JPanel myPanel = new JPanel();
    private JLabel label_background = new JLabel();
    private JLabel label_score = new JLabel();
    private JLabel label_blood = new JLabel();
    private JLabel label_win = new JLabel();
    private JLabel label_exit = new JLabel();
    private JLabel label_R = new JLabel();
    int score1,score2,score3,score4,score5;
    int sum = 0;
    int blood = 5;
    /*
     * 144,155-144,553    450,241-450,640    819,189-819,566  719,88-719-488   507,332-507,730
     * */

    public App(){
        myPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x =e.getX();
                int y =e.getY();
                if (x>135 && x<155 && ((y>145 && y<165) || (y>540 && y<560))){
                    score1 = 10;
                }
                else if (x>440 && x<460 && ((y>235 && y<247) || (y>630 && y<650))){
                    score2 = 10;
                }
                else if (x>810 && x<830 && ((y>180 && y<200) || (y>580 && y<610))){
                    score3 = 10;
                }
                else if (x>710 && x<730 && ((y>80 && y<95) || (y>480 && y<500))){
                    score4 = 10;
                }
                else if (x>495 && x<520 && ((y>320 && y<345) || (y>720 && y<740))){
                    score5 = 10;
                }
                else{
                    blood--;
                }
                sum = score1 + score2 + score3 + score4 + score5;
                String str1 = "*";
                String str2 = "";
                for(int i = 0;i<blood;i++){
                    str2+=str1;
                }
                label_R.setText("R("+x+","+y+")");
                if(sum<50){
                    label_score.setText("分数栏：" + sum);
                    label_blood.setText("生命：" + str2);
                }
                if(sum==50 || blood<1){
                    label_score.setVisible(false);
                    label_blood.setVisible(false);
                    label_R.setVisible(false);
                    label_win.setVisible(true);
                    label_exit.setVisible(true);
                    if(sum==50){
                        label_win.setText("You Win!");
                        label_exit.setText("退出游戏!");
                    }
                    if(blood<1){
                        label_win.setText("You Lose!");
                        label_exit.setText("退出游戏!");
                    }
                }
//                System.out.println(e.getX()+","+e.getY());
            }
        });

        label_win.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                score1=0;
                score2=0;
                score3=0;
                score4=0;
                score5=0;
                sum=0;
                blood=5;
                label_score.setVisible(true);
                label_blood.setVisible(true);
                label_R.setVisible(true);
                label_win.setVisible(false);
                label_exit.setVisible(false);
                label_score.setText("分数栏：0");
                label_blood.setText("生命：*****");
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

        java.net.URL imgBackground = App.class.getResource("img/background.gif");
        label_background.setIcon(new ImageIcon(imgBackground));
        label_background.setBounds(0,0,1000,800);

        label_score.setFont(new Font("宋体",Font.BOLD,24));
        label_score.setForeground(Color.red);
        label_score.setBounds(20,20,200,50);
        label_score.setText("分数栏：0");

        label_blood.setFont(new Font("宋体",Font.BOLD,24));
        label_blood.setForeground(Color.red);
        label_blood.setBounds(20,70,200,50);
        label_blood.setText("生命：*****");

        label_win.setFont(new Font("宋体",Font.BOLD,72));
        label_win.setBounds(300,200,400,200);
        label_win.setForeground(Color.red);
        label_win.setVisible(false);

        label_exit.setFont(new Font("宋体",Font.BOLD,72));
        label_exit.setBounds(300,400,400,200);
        label_exit.setForeground(Color.red);
        label_exit.setVisible(false);

        label_R.setFont(new Font("宋体",Font.BOLD,18));
        label_R.setBounds(850,20,100,50);
        label_R.setForeground(Color.red);
        label_R.setVisible(true);

        myPanel.add(label_score);
        myPanel.add(label_blood);
        myPanel.add(label_win);
        myPanel.add(label_exit);
        myPanel.add(label_R);
        myPanel.add(label_background);



        JFrame frame = new JFrame("来找茬");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1000,800);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new App().start();
    }
}
