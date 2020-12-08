package com.sjxy;

public class App {
	static int[][] array2d = {
			{1,3,5,7,9},
			{2,4,6,8,0},
			{10,30,50,70},
			{20,40,60,80},
			{4,8,16,32,64,128}	
	};
	
	public static void main(String[] args) {
		int[] num = new Find().findZero(array2d); 
		System.out.println("R_Zero("+num[0]+","+num[1]+")\n");
		new Find().findLeft(array2d, num);
		new Find().findRight(array2d, num);
		new Find().findUp(array2d, num);
		new Find().findDown(array2d, num);
	}

}
