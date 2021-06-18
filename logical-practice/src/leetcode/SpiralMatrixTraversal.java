package leetcode;

import java.util.Scanner;

public class SpiralMatrixTraversal {

	public static void main(String[] args) {
		
		Integer x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter matrix size: ");
		x=sc.nextInt();
		y=sc.nextInt();
		Integer[][] matrix = new Integer[x][y];

		initMatrix(matrix, x, y, sc);
		System.out.println("Printing Spiral matrix \n");
		spiralPrint(matrix, 0, x, 0, y, "R");
		
	}
	
	static void initMatrix(Integer[][] matrix, Integer x, Integer y, Scanner sc) {
		System.out.println("Matrix Size: "+x+"x"+y+" Enter "+(x*y)+" values");
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				//System.out.println("Enter "+(i+1)+"x"+(j+1));
				Integer temp = sc.nextInt();
				matrix[i][j]=temp;
			}
		}		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				System.out.print(matrix[i][j]+"\t");	
			}
			System.out.println();
		}
	}
	
	static void spiralPrint(Integer[][] matrix, Integer x1, Integer x2, Integer y1, Integer y2, String dir) {
		//System.out.println("x1: "+x1+" | x2: "+x2+" | y1: "+y1+" | y2: "+y2);
		
		if(x1==x2 || y1==y2)
			return;
		
		if(dir.equalsIgnoreCase("R")) {
			for(int i=y1; i<y2; i++) {
				System.out.print(matrix[x1][i]+" ");
			}
			//System.out.println();
			spiralPrint(matrix, x1+1, x2, y1, y2, "D");
		}
		if(dir.equalsIgnoreCase("D")) {
			for(int i=x1; i<x2; i++) {
				System.out.print(matrix[i][y2-1]+" ");
			}
			//System.out.println();
			spiralPrint(matrix, x1, x2, y1, y2-1, "L");
		}
		if(dir.equalsIgnoreCase("L")) {
			for(int i=y2-1; i>=y1; i--) {
				System.out.print(matrix[x2-1][i]+" ");
			}
			//System.out.println();
			spiralPrint(matrix, x1, x2-1, y1, y2, "U");
		}
		if(dir.equalsIgnoreCase("U")) {
			for(int i=x2-1; i>=x1; i--) {
				System.out.print(matrix[i][y1]+" ");
			}
			//System.out.println();
			spiralPrint(matrix, x1, x2, y1+1, y2, "R");
		}
	}
	
}
