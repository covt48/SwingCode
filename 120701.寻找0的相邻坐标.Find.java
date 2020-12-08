package com.sjxy;

public class Find {
	int[] findZero(int[][] array2d) {
		int row = 0;
		int column = 0;
		int[] R = new int[2];
		for(int[] row_num:array2d) {
			for(int column_num:row_num) {
				if(column_num==0) {
//					System.out.println("R("+column+","+row+")");
					R[0]=column;
					R[1]=row;
					break;
				}
				column++;
			}
			row++;
			column=0;
		}
		return R;
		
	}
	
	void findLeft(int[][] array2d,int[] R) {
		try {
			int i = array2d[R[1]][R[0]-1];
			System.out.println("R_Left("+(R[0]-1)+","+(R[1])+")\n");
		}catch (Exception e) {
			System.out.println("R_Left("+(R[0])+","+R[1]+")\n");
		}
	}
	
	void findRight(int[][] array2d,int[] R) {
		try {
			int i = array2d[R[1]][R[0]+1];
			System.out.println("R_Right("+(R[0]+1)+","+(R[1])+")\n");
		}catch (Exception e) {
			System.out.println("R_Right("+(R[0])+","+R[1]+")\n");
		}
	}
	
	void findUp(int[][] array2d,int[] R) {
		try {
			int i = array2d[R[1]-1][R[0]];
			System.out.println("R_Up("+(R[0])+","+(R[1]-1)+")\n");
		}catch (Exception e) {
			System.out.println("R_Up("+(R[0])+","+R[1]+")\n");
		}
	}
	
	void findDown(int[][] array2d,int[] R) {
		try {
			int i = array2d[R[1]+1][R[0]];
			System.out.println("R_Up("+(R[0])+","+(R[1]+1)+")\n");
		}catch (Exception e) {
			System.out.println("R_Down("+(R[0])+","+R[1]+")\n");
		}
	}
}
