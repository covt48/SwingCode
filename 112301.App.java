import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("程序开始，请输入【1】获取R的坐标，输入【0】结束 程序：");
		Scanner scan = new Scanner(System.in);
		while (true) {
			int in = scan.nextInt();
			int x = (int)(Math.random()*100%100);
			int y = (int)(Math.random()*100%100);
			if(in == 1){
				System.out.println("R("+x+","+y+")");
			}
			if(in == 0) {
				System.out.println("程序结束！");
				break;
			}
			if(in != 1 && in != 0){
				System.out.println("输入错误！");
			}
		}
	}

}
