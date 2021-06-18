package logical;

public class ArrayWithMax1s {

	static int[][] matrix = {{0,0,0,0,1},{0,0,0,1,1},{0,0,1,1,1},{0,1,1,1,1},{0,0,0,0,0}};
	/*
	 * 0,0,0,0,1
	 * 0,0,0,1,1
	 * 0,0,1,1,1
	 * 0,1,1,1,1
	 * 0,0,0,0,0
	 */
	/*
	 * Traverse each row from end
	 * break inner loop if zero is encountered
	 * start next loop from where previous loop ended
	 * */
	
	public static void main(String[] args) {
		
		int curr = matrix[0].length-1;
		
		for(int row=0; row<matrix.length; row++) {
			for(int col = curr; col>=0; col--) {
				if(matrix[row][col]==0) {
					if(curr>=col)
						curr = col;
					break;
				}
			}
		}
		
		System.out.println(matrix[0].length-1-curr);
	}
	
}
