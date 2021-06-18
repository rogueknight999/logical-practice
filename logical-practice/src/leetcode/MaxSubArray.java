package leetcode;

public class MaxSubArray {

	public static void main(String[] args) {
		
		int arr[] = {11, 5, -10, 4, 5, -4, -6, 12,-11, 10, -5};
		int maxSoFar=0;
		int maxTillHere=0;
		int start=0;
		int end=0;
		int curr=0;
		
		for(int i=0; i<arr.length; i++) {
			
			maxTillHere += arr[i];
			if(maxSoFar<maxTillHere) {
				maxSoFar=maxTillHere;
				start=curr;
				end=i;
			}
			
			if(maxTillHere<0) {
				maxTillHere=0;
				curr=i+1;
			}
			
		}
		System.out.println(maxSoFar);
		System.out.println(start+"|"+end);
		
	}
	
}
