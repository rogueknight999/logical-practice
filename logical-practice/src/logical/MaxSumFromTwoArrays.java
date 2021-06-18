package logical;

/*
 * Given 2 sorted Arrays, find the max sum that can be achieved by traversing an array and swapping between arrays at intersection points if required.  
 * i/p: A=[1, 3, 5, 8, 10, 12, 14]
 * 		B=[2, 5, 6, 7, 8, 11, 13, 14, 16, 17]
 * OP:  1+3+5+6+7+8+11+13+14+16+17
 * 
 * Arrays are switched at intersection points i.e. values common in both arrays.
 * 
 */
public class MaxSumFromTwoArrays {
	
	public static void main(String[] args) {
		
		int[] arrA = new int[] {1, 3, 5, 8, 10, 12, 14, 20};
		int[] arrB = new int[] {2, 5, 6, 7, 8, 11, 13, 14, 16, 17};
		
		int ptrA=0;
		int ptrB=0;
		int sumA=0;
		int sumB=0;
		int totalSum=0;
		
		while(ptrA<arrA.length && ptrB<arrB.length) {
			if(arrA[ptrA]<arrB[ptrB]) {
				sumA+=arrA[ptrA];
				ptrA++;
			}
			else if(arrB[ptrB]<arrA[ptrA]) {
				sumB+=arrB[ptrB];
				ptrB++;
			}
			else {
				sumA+=arrA[ptrA]; sumB+=arrB[ptrB];
				totalSum+= sumA>sumB ? sumA : sumB;
				sumA=0; sumB=0;
				ptrA++; ptrB++;
			}
		}
		
		for(int i=ptrA; i<arrA.length; i++)
			sumA+=arrA[i];
		for(int i=ptrB; i<arrB.length; i++) 
			sumB+=arrB[i];
		
		totalSum+= sumA>sumB ? sumA : sumB;
		
		System.out.println(totalSum);
	}
	
}